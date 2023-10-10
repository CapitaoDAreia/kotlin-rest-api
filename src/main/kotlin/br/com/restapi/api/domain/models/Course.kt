package br.com.restapi.api.domain.models

data class Course(
    val id: Long? = null,
    val name: String,
    val category: String
)