package br.com.restapi.api.infraestructure.controllers

import br.com.restapi.api.application.services.TopicService
import br.com.restapi.api.domain.dto.ListTopicsResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
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
}