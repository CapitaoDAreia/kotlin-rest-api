package br.com.restapi.api.infraestructure.controllers

import br.com.restapi.api.application.services.TopicService
import br.com.restapi.api.domain.dto.topicDTO.NewTopicDTO
import br.com.restapi.api.domain.dto.topicDTO.TopicResponseDTO
import br.com.restapi.api.domain.dto.topicDTO.UpdateTopicDTO
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

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
    fun searchTopic(@PathVariable topicId: Long): ResponseEntity<TopicResponseDTO> {
        val result = topicService.searchTopic(topicId)
        return ResponseEntity.ok(result)
    }

    @PostMapping
    fun postTopic(@RequestBody @Valid dto: NewTopicDTO, uriBuilber: UriComponentsBuilder): ResponseEntity<Any> {
        val topic = topicService.registerTopic(dto)
        val uri = uriBuilber.path("/topic/${topic.id}").build().toUri()
        return ResponseEntity.created(uri).body(topic)
    }

    @PutMapping
    fun updateTopic(@RequestBody @Valid dto: UpdateTopicDTO): ResponseEntity<Any> {
        val newTopic = topicService.updateTopic(dto)
        return ResponseEntity.ok(newTopic)
    }

    @DeleteMapping("/{topicId}")
    fun deleteTopic(@PathVariable topicId: Long): ResponseEntity<Any> {
        topicService.deleteTopic(topicId)
        return ResponseEntity.noContent().build()
    }
}