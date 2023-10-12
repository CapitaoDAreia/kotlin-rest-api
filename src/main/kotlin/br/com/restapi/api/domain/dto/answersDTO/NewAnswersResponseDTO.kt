package br.com.restapi.api.domain.dto.answersDTO

import br.com.restapi.api.domain.models.Answer
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import java.time.LocalDateTime

data class NewAnswersResponseDTO(
    val id: Long? = null,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean
){
    constructor(answer: Answer): this(
        answer.id,
        answer.message,
        answer.creationDate,
        answer.author,
        answer.topic,
        answer.solution
    )
}
