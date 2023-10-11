package br.com.restapi.api.application.services.mapper.topic

import br.com.restapi.api.application.services.CourseService
import br.com.restapi.api.application.services.UserService
import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.domain.dto.topicDTO.NewTopicDTO
import br.com.restapi.api.domain.models.Topic
import org.springframework.stereotype.Component

@Component
class NewTopicDtoToTopic(
    private var userService: UserService,
    private var courseService: CourseService,
): Mapper<NewTopicDTO, Topic> {
    override fun map(t: NewTopicDTO): Topic {
        val course = courseService.searchCourse(t.courseId)
        val user = userService.searchUser(t.authorId)

        return Topic(
            id = null,
            t.title,
            t.message,
            course,
            user,
        )
    }
}