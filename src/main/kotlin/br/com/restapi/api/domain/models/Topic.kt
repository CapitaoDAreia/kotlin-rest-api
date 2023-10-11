package br.com.restapi.api.domain.models

import br.com.restapi.api.domain.enums.StatusTopic
import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val course: Course,
    val author: User,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answers: MutableList<Answer> = ArrayList()
)