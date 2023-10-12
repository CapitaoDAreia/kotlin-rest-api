package br.com.restapi.api.application.services.mapper.topic

import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.domain.dto.topicDTO.TopicResponseDTO
import br.com.restapi.api.domain.models.Topic
import org.springframework.stereotype.Component

@Component
class TopicResponseDtoToTopicMapper: Mapper<TopicResponseDTO, Topic>{
    override fun map(t: TopicResponseDTO): Topic {
        return Topic(
            t.id,
            t.title,
            t.message,
            t.course,
            t.author,
            t.creationDate,
            t.status,
            t.answers
        )
    }
}
