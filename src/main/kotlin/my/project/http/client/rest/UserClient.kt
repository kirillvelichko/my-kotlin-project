package my.project.http.client.rest

import my.project.data.dto.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET

@FeignClient("user", url = "https://localhost:443")
interface UserClient {
    @RequestMapping(method = [GET], value = ["/getUser/{login}"])
    fun getUser(@PathVariable login: String): User
}