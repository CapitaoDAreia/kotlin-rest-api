package br.com.restapi.api.application.services.mapper.topic

import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.domain.dto.topicDTO.TopicResponseDTO
import br.com.restapi.api.domain.models.Topic
import org.springframework.stereotype.Component

@Component
class TopicToTopicResponseDtoMapper: Mapper<Topic, TopicResponseDTO> {
    override fun map(t: Topic): TopicResponseDTO{
        return TopicResponseDTO(t.id, t.title, t.message, t.course, t.author)
    }
}