package my.project.service

import my.project.data.dto.User
import my.project.gen.jaxb.GetUserRequest
import my.project.gen.jaxb.GetUserResponse
import my.project.http.client.rest.UserClient
import my.project.http.client.soap.UserSoapClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userClient: UserClient
    @Autowired
    lateinit var userSoapClient: UserSoapClient

    fun getUser(login: String): User {
        return userClient.getUser(login)
    }

    fun getUserSoap(login: String): GetUserResponse {
        val request = GetUserRequest()
        request.login = login
        return userSoapClient.getUser(request)
    }
}