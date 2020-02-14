package my.project.http.client.soap

import my.project.config.UserSoapClientConfig
import my.project.gen.jaxb.CreateUserRequest
import my.project.gen.jaxb.CreateUserResponse
import my.project.gen.jaxb.GetUserRequest
import my.project.gen.jaxb.GetUserResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@FeignClient(
        name = "userSoap",
        url = "https://localhost:443",
        configuration = [UserSoapClientConfig::class]
)
interface UserSoapClient {

    @PostMapping(value = ["/ws"], consumes = ["text/xml"])
    fun getUser(@RequestBody request: GetUserRequest): GetUserResponse

    @PostMapping(value = ["/ws"], consumes = ["text/xml"])
    fun createUser(@RequestBody request: CreateUserRequest): CreateUserResponse
}