package my.project.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import my.project.config.kafka.topicNameDeleteUser
import my.project.config.kafka.topicNameUpdateUser
import my.project.data.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaClient {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    @Autowired
    private lateinit var mapper: ObjectMapper

    fun deleteUser(login: String?): String? {
        login?.let {
            kafkaTemplate.send(topicNameDeleteUser, login)
            println("Kafka msg was send with topic: $topicNameDeleteUser")
        }
        return "Request for delete user $login was send"
    }

    fun updateUser(login: String?, password: String?): String? {
        if (login != null && password != null) {
            val user = User(login, password)
            kafkaTemplate.send(topicNameUpdateUser, mapper.writeValueAsString(user))
            println("Kafka msg was send with topic: $topicNameUpdateUser")
        }
        return "Request for update user $login was send"
    }
}