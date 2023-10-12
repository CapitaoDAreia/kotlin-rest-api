package br.com.restapi.api.application.services

import br.com.restapi.api.application.services.mapper.answer.NewAnswersDtoToAnswer
import br.com.restapi.api.domain.dto.answersDTO.NewAnswersDTO
import br.com.restapi.api.domain.dto.answersDTO.NewAnswersResponseDTO
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private var newAnswersDtoToAnswer: NewAnswersDtoToAnswer,
    private var topicService: TopicService
) {
    fun registerAnswerOnATopic(dto: NewAnswersDTO, topicId: Long): NewAnswersResponseDTO {
        val answer = newAnswersDtoToAnswer.map(dto)
        val topic = topicService.searchTopic(topicId)
        topic.answers.add(answer)

        return NewAnswersResponseDTO(answer)
    }
}