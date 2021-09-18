package my.project.config

import org.apache.catalina.Context
import org.apache.tomcat.util.descriptor.web.SecurityCollection
import org.apache.tomcat.util.descriptor.web.SecurityConstraint
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean

@SpringBootConfiguration
class WebServerConfig {
    @Bean
    fun servletContainer(): ServletWebServerFactory {
        return object : TomcatServletWebServerFactory() {
            override fun postProcessContext(context: Context) {
                val constraint = SecurityConstraint()
                constraint.userConstraint = "CONFIDENTIAL"
                val collection = SecurityCollection()
                collection.addPattern("/*")
                constraint.addCollection(collection)
                context.addConstraint(constraint)
            }
        }
    }
}