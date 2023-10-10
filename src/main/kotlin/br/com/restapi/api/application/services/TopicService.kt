package br.com.restapi.api.application.services

import br.com.restapi.api.domain.dto.ListTopicsResponseDTO
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TopicService(
    private var topics: MutableList<Topic>
) {
    init {
        val user = User(1, "user", "user@email.com")
        val course = Course(1, "name", "category")

        val topic1 = Topic(1, "title", "message", LocalDateTime.now(), course, user)
        val topic2 = Topic(2, "title", "message", LocalDateTime.now(), course, user)
        val topic3 = Topic(3, "title", "message", LocalDateTime.now(), course, user)

        topics.addAll(listOf(topic1, topic2, topic3))
    }

    fun listTopics(): List<ListTopicsResponseDTO>{
        return listOf(ListTopicsResponseDTO(topics))
    }
}