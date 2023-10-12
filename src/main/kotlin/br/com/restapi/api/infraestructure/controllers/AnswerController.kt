package br.com.restapi.api.infraestructure.controllers

import br.com.restapi.api.application.services.AnswerService
import br.com.restapi.api.application.services.TopicService
import br.com.restapi.api.domain.dto.answersDTO.NewAnswersDTO
import br.com.restapi.api.domain.dto.topicDTO.ListAnswersOfATopicResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/answers")
class AnswerController(
    private val answerService: AnswerService,
    private val topicService: TopicService
) {
    @PostMapping("/register/{topicId}")
    fun registerAnswerOnATopic(@RequestBody dto: NewAnswersDTO, @PathVariable topicId: Long): ResponseEntity<Any>{
        answerService.registerAnswerOnATopic(dto, topicId)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping("/{topicId}")
    fun searchTopicResponses(@PathVariable topicId: Long): ResponseEntity<ListAnswersOfATopicResponseDTO>{
        val topic = topicService.searchTopic(topicId)
        val answers = topic.answers
        val dto = ListAnswersOfATopicResponseDTO(answers)
        return ResponseEntity.ok(dto)
    }
}