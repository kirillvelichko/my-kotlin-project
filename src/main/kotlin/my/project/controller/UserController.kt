package my.project.controller

import com.fasterxml.jackson.databind.ObjectMapper
import my.project.data.model.User
import my.project.kafka.KafkaClient
import my.project.rabbit.RabbitClient
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val rabbit: RabbitClient, val kafka: KafkaClient) {

    @GetMapping("/createUser/{login}")
    fun createUser(@PathVariable login: String?): String? {
        return rabbit.createUser(login)
    }

    @GetMapping("/getUser/{login}")
    fun getUser(@PathVariable login: String?): String? {
        return rabbit.getUser(login)
    }

    @GetMapping("/deleteUser/{login}")
    fun deleteUser(@PathVariable login: String?): String? {
        return kafka.deleteUser(login)
    }

    @GetMapping("/updateUser/{login}/{password}")
    fun updateUser(@PathVariable login: String?, @PathVariable password: String?): String? {
        return kafka.updateUser(login, password)
    }
}