package br.com.restapi.api.application.services

import br.com.restapi.api.domain.dto.ListTopicResponseDTO
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TopicService {
    fun listTopics(): List<ListTopicResponseDTO>{
        val user = User(1, "user", "user@email.com")
        val course = Course(1, "name", "category")
        val topic = Topic(1, "title", "message", LocalDateTime.now(), course, user)
//        val answer = Answer(1, "message", LocalDateTime.now(), user, topic, false)
        return listOf(ListTopicResponseDTO(topic))
    }
}