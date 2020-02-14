package my.project.controller

import com.fasterxml.jackson.databind.ObjectMapper
import my.project.data.model.User
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val rabbitTemplate: RabbitTemplate, val mapper: ObjectMapper) {

    @GetMapping("/createUser/{login}")
    fun createUser(@PathVariable login: String?): String? {
        var response: Message? = null
        if (login != null) {
            val user = User(login, "kotlinPWD")
            val message = Message(mapper.writeValueAsBytes(user), MessageProperties())
            response = rabbitTemplate.sendAndReceive("my-direct-exchange", "user.create", message)
        }

        return response?.body?.let { String(it) }
    }

    @GetMapping("/getUser/{login}")
    fun getUser(@PathVariable login: String?): String? {
        var response: Message? = null
        if (login != null) {
            val message = Message(login.toByteArray(), MessageProperties())
            response = rabbitTemplate.sendAndReceive("my-direct-exchange", "user.get", message)
        }

        return response?.body?.let { String(it) }
    }
}