package br.com.restapi.api.domain.dto.topicDTO

import br.com.restapi.api.domain.enums.StatusTopic
import br.com.restapi.api.domain.models.Answer
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import java.time.LocalDateTime

data class TopicResponseDTO(
    val id: Long?,
    val title: String,
    val message: String,
    val course: Course,
    val author: User,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answers: MutableList<Answer> = ArrayList()
)
