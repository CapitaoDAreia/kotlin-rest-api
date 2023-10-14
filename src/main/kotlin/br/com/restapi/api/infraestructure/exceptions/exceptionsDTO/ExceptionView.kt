package br.com.restapi.api.infraestructure.exceptions.exceptionsDTO

import java.time.LocalDateTime

data class ExceptionView(
    val message: String?,
    val error: String,
    val httpStatus: Int,
    val path: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
