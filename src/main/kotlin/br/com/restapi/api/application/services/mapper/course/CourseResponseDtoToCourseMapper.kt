package br.com.restapi.api.application.services.mapper.course

import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.domain.dto.courseDTO.CourseResponseDTO
import br.com.restapi.api.domain.models.Course
import org.springframework.stereotype.Component

@Component
class CourseResponseDtoToCourseMapper: Mapper<CourseResponseDTO, Course> {
    override fun map(t: CourseResponseDTO): Course{
        return Course(t)
    }
}