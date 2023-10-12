package br.com.restapi.api.application.services.mapper.course

import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.domain.dto.courseDTO.CourseResponseDTO
import br.com.restapi.api.domain.models.Course
import org.springframework.stereotype.Component

@Component
class CourseToCourseResponseDtoMapper: Mapper<Course, CourseResponseDTO> {
    override fun map(t: Course): CourseResponseDTO{
        return CourseResponseDTO(t.id, t.name, t.category)
    }
}