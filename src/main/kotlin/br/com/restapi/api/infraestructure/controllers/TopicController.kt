package br.com.restapi.api.infraestructure.controllers

import br.com.restapi.api.domain.dto.ListTopicResponseDTO
import br.com.restapi.api.domain.models.Answer
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/topic")
class TopicController {

    @GetMapping
    fun listTopics(): ResponseEntity<List<ListTopicResponseDTO>>{
        val response = buildResponse()
        return ResponseEntity.ok(response)
    }

    private fun buildResponse(): List<ListTopicResponseDTO>{
        val user = User(1, "user", "user@email.com")
        val course = Course(1, "name", "category")
        val topic = Topic(1, "title", "message", LocalDateTime.now(), course, user)
//        val answer = Answer(1, "message", LocalDateTime.now(), user, topic, false)
        return listOf(ListTopicResponseDTO(topic))
    }
}