package br.com.restapi.api.domain.dto.answersDTO

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class NewAnswersDTO(
    @field:NotBlank
    val message: String,

    @field:NotNull
    val authorId: Long,

    @field:NotNull
    val topicId: Long,
)
