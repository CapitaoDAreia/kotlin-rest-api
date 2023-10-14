package br.com.restapi.api.infraestructure.controllers

import br.com.restapi.api.application.services.AnswerService
import br.com.restapi.api.application.services.TopicService
import br.com.restapi.api.domain.dto.answersDTO.NewAnswersDTO
import br.com.restapi.api.domain.dto.answersDTO.UpdateAnswerDTO
import br.com.restapi.api.domain.dto.topicDTO.ListAnswersOfATopicResponseDTO
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/answers")
class AnswerController(
    private val answerService: AnswerService,
    private val topicService: TopicService
) {
    @PostMapping("/register/{topicId}")
    fun registerAnswerOnATopic(@RequestBody dto: NewAnswersDTO, @PathVariable topicId: Long, uriBuilber: UriComponentsBuilder): ResponseEntity<Any>{
        val answer = answerService.registerAnswerOnATopic(dto, topicId)
        val uri = uriBuilber.path("/topic/${answer.id}").build().toUri()
        return ResponseEntity.created(uri).body(answer)
    }

    @GetMapping("/{topicId}")
    fun searchTopicResponses(@PathVariable topicId: Long): ResponseEntity<ListAnswersOfATopicResponseDTO>{
        val topic = topicService.searchTopic(topicId)
        val answers = topic.answers
        val dto = ListAnswersOfATopicResponseDTO(answers)
        return ResponseEntity.ok(dto)
    }

    @PutMapping
    fun updateAnswer(@RequestBody @Valid dto: UpdateAnswerDTO): ResponseEntity<Any> {
        val newTopic = topicService.updateAnswerOfTopic(dto)
        return ResponseEntity.ok(newTopic)
    }

    @DeleteMapping("/{topicId}")
    fun deleteAnswer(@PathVariable topicId: Long, @PathVariable answerId: Long): ResponseEntity<Any> {
        topicService.deleteAnswerOfTopic(topicId, answerId)
        return ResponseEntity.noContent().build()
    }
}