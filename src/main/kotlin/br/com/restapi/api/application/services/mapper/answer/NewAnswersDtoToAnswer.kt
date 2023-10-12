package br.com.restapi.api.application.services.mapper.answer

import br.com.restapi.api.application.services.TopicService
import br.com.restapi.api.application.services.UserService
import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.application.services.mapper.topic.TopicResponseDtoToTopicMapper
import br.com.restapi.api.application.services.mapper.user.UserResponseDtoToUserMapper
import br.com.restapi.api.domain.dto.answersDTO.NewAnswersDTO
import br.com.restapi.api.domain.models.Answer
import org.springframework.stereotype.Component

@Component
class NewAnswersDtoToAnswer(
    private var userService: UserService,
    private var topicService: TopicService,
    private var userResponseDtoToUserMapper: UserResponseDtoToUserMapper,
    private var topicResponseDtoToTopicMapper: TopicResponseDtoToTopicMapper

): Mapper<NewAnswersDTO, Answer> {
    override fun map(t: NewAnswersDTO): Answer {
        val author = userResponseDtoToUserMapper.map(userService.searchUser(t.authorId))
        val topic = topicResponseDtoToTopicMapper.map(topicService.searchTopic(t.topicId))

        return Answer(
            null,
            t.message,
            author,
            topic,
            false
        )
    }
}