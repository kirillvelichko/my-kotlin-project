package my.project

import my.project.service.UserService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class Application(private val userService: UserService) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        //println(userService.getUser("test122"))
        println(userService.getUserSoap("test122").user.password)
    }
}

fun main() {
    runApplication<Application>()
}
