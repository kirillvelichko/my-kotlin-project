package my.project

import my.project.service.UserService
import my.project.service.utils.convertGetUserResponseToUser
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class Application(val userService: UserService) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("REST:")
        println(userService.createUserRest("testRest", "password"))
        println(userService.getUserRest("testRest"))
        println("SOAP:")
        println(userService.createUserSoap("testSoap", "pwd").message)
        println(convertGetUserResponseToUser(userService.getUserSoap("testSoap")))
    }
}

fun main() {
    runApplication<Application>()
}
