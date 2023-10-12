package br.com.restapi.api.domain.dto.topicDTO

import jakarta.validation.constraints.*

data class NewTopicDTO(
    @field:NotBlank @field:Size(min = 5, max = 30) val title: String,

    @field:NotBlank
    val message: String,

    @field:NotNull
    val courseId: Long,

    @field:NotNull
    val authorId: Long
)
