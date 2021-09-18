package my.project.config.kafka

import org.apache.kafka.clients.admin.AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaAdmin
import java.util.*

const val bootstrapAddress: String = "localhost:9092"
const val topicNameDeleteUser: String = "delete_user"
const val topicNameUpdateUser: String = "update_user"

@SpringBootConfiguration
class TopicConfig {
    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any?> = HashMap()
        configs[BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        return KafkaAdmin(configs)
    }

    @Bean
    fun topicDeleteUser(): NewTopic {
        return NewTopic(topicNameDeleteUser, 1, 1)
    }

    @Bean
    fun topicUpdateUser(): NewTopic {
        return NewTopic(topicNameUpdateUser, 1, 1)
    }
}