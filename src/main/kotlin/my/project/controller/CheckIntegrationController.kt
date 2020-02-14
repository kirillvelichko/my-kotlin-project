package my.project.controller

import my.project.service.UserService
import my.project.service.utils.convertGetUserResponseToUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CheckIntegrationController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/check")
    fun check(): String {
        val builder = StringBuilder()
                .append("REST: ")
                .append(userService.createUserRest("testRest", "password"))
                .append(userService.getUserRest("testRest"))
                .append(" SOAP: ")
                .append(userService.createUserSoap("testSoap", "pwd").message)
                .append(convertGetUserResponseToUser(userService.getUserSoap("testSoap")))

        return builder.toString()
    }
}