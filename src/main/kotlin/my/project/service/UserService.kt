package my.project.service

import my.project.integration.rest.UserRestClient
import my.project.model.User
import org.springframework.stereotype.Service

@Service
class UserService(val userRestClient: UserRestClient) {
    fun getUser(login: String): User {
        return userRestClient.getUser(login)
    }

    fun createUser(login: String, password: String): String {
        val user = User(login, password)
        return userRestClient.createUser(user)
    }
}