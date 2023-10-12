package br.com.restapi.api.application.services.mapper.user

import br.com.restapi.api.application.services.mapper.Mapper
import br.com.restapi.api.domain.dto.userDTO.UserResponseDTO
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Component

@Component
class UserResponseDtoToUserMapper: Mapper<UserResponseDTO, User> {
    override fun map(t: UserResponseDTO): User{
        return User(t.id, t.name, t.email)
    }
}