package br.com.restapi.api.domain.dto

import br.com.restapi.api.domain.enums.StatusTopic
import br.com.restapi.api.domain.models.Answer
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import java.time.LocalDateTime

data class ListTopicResponseDTO(
    val id: Long? = null,
    val title: String,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answers: List<Answer> = ArrayList()
){
    constructor(topic: Topic) : this(
        topic.id,
        topic.title,
        topic.message,
        topic.creationDate,
        topic.course,
        topic.author,
        topic.status,
        topic.answers
    )
}
