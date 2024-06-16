package ru.gpb.morkovnikovmiddleservice.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class RestServerConfig(
    @Value("\${backend-service.url}")
    private val baseUrl: String
) {
    @Bean
    fun restCleint(): RestClient {
        return RestClient
            .builder()
            .baseUrl(baseUrl)
            .build()
    }
}