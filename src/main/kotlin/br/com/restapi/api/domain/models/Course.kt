package br.com.restapi.api.domain.models

import br.com.restapi.api.domain.dto.courseDTO.CourseResponseDTO

data class Course(
    val id: Long,
    val name: String,
    val category: String
){
    constructor(dto: CourseResponseDTO): this(dto.id, dto.name, dto.category)
}