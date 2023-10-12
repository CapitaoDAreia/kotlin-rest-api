package br.com.restapi.api.application.services.mapper.topic

import br.com.restapi.api.application.services.CourseService
import br.com.restapi.api.application.services.UserService
import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.application.services.mapper.course.CourseResponseDtoToCourseMapper
import br.com.restapi.api.application.services.mapper.user.UserResponseDtoToUserMapper
import br.com.restapi.api.domain.dto.topicDTO.NewTopicDTO
import br.com.restapi.api.domain.models.Topic
import org.springframework.stereotype.Component

@Component
class NewTopicDtoToTopic(
    private var userService: UserService,
    private var courseService: CourseService,
    private var courseResponseDtoToCourseMapper: CourseResponseDtoToCourseMapper,
    private var userResponseDtoToUserMapper: UserResponseDtoToUserMapper
): Mapper<NewTopicDTO, Topic> {
    override fun map(t: NewTopicDTO): Topic {
        val course = courseResponseDtoToCourseMapper.map(courseService.searchCourse(t.courseId))
        val user = userResponseDtoToUserMapper.map(userService.searchUser(t.authorId))

        return Topic(
            id = null,
            t.title,
            t.message,
            course,
            user,
        )
    }
}