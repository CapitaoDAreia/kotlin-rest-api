package br.com.restapi.api.domain.dto.topicDTO

data class NewTopicDTO(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long
)
