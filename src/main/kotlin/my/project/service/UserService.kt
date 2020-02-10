package my.project.service

import my.project.data.dto.User
import my.project.gen.jaxb.*
import my.project.http.client.rest.UserRestClient
import my.project.http.client.soap.UserSoapClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userRestClient: UserRestClient

    @Autowired
    lateinit var userSoapClient: UserSoapClient

    fun getUserRest(login: String): User {
        return userRestClient.getUser(login)
    }

    fun createUserRest(login: String, password: String): String {
        val user = User("", login, password)
        return userRestClient.createUser(user)
    }

    fun getUserSoap(login: String): GetUserResponse {
        val request = GetUserRequest()
        request.login = login
        return userSoapClient.getUser(request)
    }

    fun createUserSoap(login: String, password: String): CreateUserResponse {
        val request = CreateUserRequest()
        request.user = UserSchema()
        request.user.id = ""
        request.user.login = login
        request.user.password = password
        return userSoapClient.createUser(request)
    }
}