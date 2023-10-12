package br.com.restapi.api.application.services.mapper.user

import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.domain.dto.userDTO.UserResponseDTO
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Component

@Component
class UserToUserResponseDtoMapper: Mapper<User, UserResponseDTO> {
    override fun map(t: User): UserResponseDTO{
        return UserResponseDTO(t.id, t.name, t.email)
    }
}