package br.com.restapi.api.infraestructure.controllers

import br.com.restapi.api.application.services.TopicService
import br.com.restapi.api.domain.dto.topicDTO.NewTopicDTO
import br.com.restapi.api.domain.dto.topicDTO.TopicResponseDTO
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic")
class TopicController(
    private val topicService: TopicService
) {
    @GetMapping
    fun listTopics(): ResponseEntity<List<TopicResponseDTO>> {
        val result = topicService.listTopics()
        return ResponseEntity.ok(result)
    }

    @GetMapping("/{topicId}")
    fun searchTopic(@PathVariable topicId: Long): ResponseEntity<TopicResponseDTO>{
        val result = topicService.searchTopic(topicId)
        return ResponseEntity.ok(result)
    }

    @PostMapping
    fun postTopic(@RequestBody @Valid dto: NewTopicDTO): ResponseEntity<Any>{
        topicService.registerTopic(dto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}