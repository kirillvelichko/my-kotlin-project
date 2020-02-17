package my.project.rabbit

import com.fasterxml.jackson.databind.ObjectMapper
import my.project.data.model.User
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RabbitClient {

    @Autowired
    private lateinit var rabbit: RabbitTemplate

    @Autowired
    private lateinit var mapper: ObjectMapper

    fun createUser(login: String?): String? {
        var response: Message? = null
        if (login != null) {
            val user = User(login, "kotlinPWD")
            val message = Message(mapper.writeValueAsBytes(user), MessageProperties())
            response = rabbit.sendAndReceive("my-direct-exchange", "user.create", message)
        }

        return response?.body?.let { String(it) }
    }

    fun getUser(login: String?): String? {
        var response: Message? = null
        if (login != null) {
            val message = Message(login.toByteArray(), MessageProperties())
            response = rabbit.sendAndReceive("my-direct-exchange", "user.get", message)
        }

        return response?.body?.let { String(it) }
    }
}