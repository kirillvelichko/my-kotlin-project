package my.project.http.client.rest

import my.project.data.model.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
        name = "userRest",
        url = "https://localhost:443"
)
interface UserRestClient {

    @GetMapping("/getUser/{login}")
    fun getUser(@PathVariable login: String): User

    @PostMapping("/createUser")
    fun createUser(@RequestBody user: User): String
}