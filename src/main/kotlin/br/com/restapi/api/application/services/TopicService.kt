package br.com.restapi.api.application.services

import br.com.restapi.api.domain.dto.topicDTO.ListTopicsResponseDTO
import br.com.restapi.api.domain.dto.topicDTO.NewTopicDTO
import br.com.restapi.api.domain.dto.topicDTO.TopicResponseDTO
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TopicService(
    private var topicsStub: MutableList<Topic> = ArrayList(),
    private var userService: UserService,
    private var courseService: CourseService

) {
    init {
        topicsStub.add(
            Topic(
                1, "title", "message",
                Course(1, "course", "category"),
                User(1, "name", "email")
            )
        )
    }

    fun listTopics(): List<Topic> {
        return topicsStub
    }

    fun searchTopic(id: Long): Topic {
        val topic = topicsStub.stream().filter { t -> t.id == id }.findFirst().get()
        return topic
    }

    fun registerTopic(dto: NewTopicDTO) {
        val course = courseService.searchCourse(dto.courseId)
        val user = userService.searchUser(dto.authorId)

        val topic = Topic(
            id = topicsStub.size.toLong(),
            dto.title,
            dto.message,
            course,
            user,
        )

        topicsStub.plus(topic)
    }
}