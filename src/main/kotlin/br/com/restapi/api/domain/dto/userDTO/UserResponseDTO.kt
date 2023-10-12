package br.com.restapi.api.domain.dto.userDTO

import br.com.restapi.api.domain.models.User

data class UserResponseDTO(val id: Long, val name: String, val email: String)
