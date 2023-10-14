package br.com.restapi.api.domain.dto.answersDTO

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateAnswerDTO(
    @field:NotNull
    val id: Long,
    @field:NotBlank
    val message: String,
    @field:NotNull
    val topicId: Long,
    @field:NotNull
    val solution: Boolean,
)
