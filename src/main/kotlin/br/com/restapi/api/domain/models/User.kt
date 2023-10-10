package br.com.restapi.api.domain.models

data class User(
    val id: Long? = null,
    val name: String,
    val email: String
)
