package br.com.restapi.api.infraestructure.controllers

import br.com.restapi.api.application.services.TopicService
import br.com.restapi.api.domain.dto.ListAnswersOfATopicResponseDTO
import br.com.restapi.api.domain.dto.ListTopicsResponseDTO
import br.com.restapi.api.domain.dto.TopicResponseDTO
import br.com.restapi.api.domain.models.Answer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic")
class TopicController(
    private val topicService: TopicService
) {
    @GetMapping
    fun listTopics(): ResponseEntity<List<ListTopicsResponseDTO>>{
        val response = topicService.listTopics()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{topicId}")
    fun searchTopic(@PathVariable topicId: Long): ResponseEntity<TopicResponseDTO>{
        val response = topicService.searchTopic(topicId)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/answers/{topicId}")
    fun searchTopicResponses(@PathVariable topicId: Long): ResponseEntity<ListAnswersOfATopicResponseDTO>{
        val topic = topicService.searchTopic(topicId)
        val answers = topic.answers
        val dto = ListAnswersOfATopicResponseDTO(answers)
        return ResponseEntity.ok(dto)
    }
}