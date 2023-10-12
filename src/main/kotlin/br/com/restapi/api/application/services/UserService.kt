package br.com.restapi.api.application.services

import br.com.restapi.api.application.services.mapper.user.UserToUserResponseDtoMapper
import br.com.restapi.api.domain.dto.userDTO.UserResponseDTO
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private var userStub: MutableList<User> = ArrayList(),
    private var userToUserResponseDtoMapper: UserToUserResponseDtoMapper
) {
    init {
        userStub.add(User(1, "name", "email"))
    }
    fun listUsers(): List<UserResponseDTO> {
        return userStub.map { t -> userToUserResponseDtoMapper.map(t) }
    }

    fun searchUser(id: Long): UserResponseDTO {
        val user = userStub.stream().filter { u -> u.id == id }.findFirst().get()
        return userToUserResponseDtoMapper.map(user)
    }

}