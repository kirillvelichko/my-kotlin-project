package my.project.config

import feign.codec.Decoder
import feign.codec.Encoder
import feign.jaxb.JAXBContextFactory
import feign.soap.SOAPDecoder
import feign.soap.SOAPEncoder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class UserSoapClientConfig {
    @Bean
    fun feignEncoder(): Encoder {
        return SOAPEncoder(jaxbFactory)
    }

    @Bean
    fun feignDecoder(): Decoder {
        return SOAPDecoder(jaxbFactory)
    }

    companion object {
        private val jaxbFactory: JAXBContextFactory = JAXBContextFactory.Builder()
                .withMarshallerJAXBEncoding("UTF-8")
                .withMarshallerSchemaLocation("https://localhost:443/ws/user.wsdl")
                .build()
    }
}