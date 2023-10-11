package br.com.restapi.api.application.services

import br.com.restapi.api.domain.dto.courseDTO.CourseResponseDTO
import br.com.restapi.api.domain.dto.courseDTO.ListCoursesResponseDTO
import br.com.restapi.api.domain.dto.topicDTO.ListTopicsResponseDTO
import br.com.restapi.api.domain.dto.topicDTO.NewTopicDTO
import br.com.restapi.api.domain.dto.topicDTO.TopicResponseDTO
import br.com.restapi.api.domain.dto.userDTO.ListUsersResponseDTO
import br.com.restapi.api.domain.dto.userDTO.UserResponseDTO
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private var userStub: MutableList<User> = ArrayList()
) {
    init {
        userStub.add(User(1, "name", "email"))
    }
    fun listUsers(): List<User> {
        return userStub
    }

    fun searchUser(id: Long): User {
        val user = userStub.stream().filter { u -> u.id == id }.findFirst().get()
        return user
    }

}