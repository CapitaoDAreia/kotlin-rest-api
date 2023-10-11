package br.com.restapi.api.application.services

import br.com.restapi.api.domain.dto.courseDTO.CourseResponseDTO
import br.com.restapi.api.domain.dto.courseDTO.ListCoursesResponseDTO
import br.com.restapi.api.domain.dto.topicDTO.ListTopicsResponseDTO
import br.com.restapi.api.domain.dto.topicDTO.NewTopicDTO
import br.com.restapi.api.domain.dto.topicDTO.TopicResponseDTO
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Service

@Service
class CourseService(
    private var courseStub: MutableList<Course> = ArrayList()
) {
    init {
        courseStub.add(Course(1, "course", "category"))
    }

    fun listCourses(): List<Course> {
        return courseStub
    }

    fun searchCourse(id: Long): Course {
        val course = courseStub.stream().filter { c -> c.id == id }.findFirst().get()
        return course
    }

}