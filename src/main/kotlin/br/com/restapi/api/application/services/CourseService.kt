package br.com.restapi.api.application.services

import br.com.restapi.api.application.services.mapper.course.CourseToCourseResponseDtoMapper
import br.com.restapi.api.domain.dto.courseDTO.CourseResponseDTO
import br.com.restapi.api.domain.models.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    private var courseStub: MutableList<Course> = ArrayList(),
    private var courseResponseDtoMapper: CourseToCourseResponseDtoMapper
) {
    init {
        courseStub.add(Course(1, "course", "category"))
    }

    fun listCourses(): List<CourseResponseDTO> {
        return courseStub.map{ t -> courseResponseDtoMapper.map(t) }
    }

    fun searchCourse(id: Long): CourseResponseDTO {
        val course = courseStub.stream().filter { c -> c.id == id }.findFirst().get()
        return courseResponseDtoMapper.map(course)
    }
}