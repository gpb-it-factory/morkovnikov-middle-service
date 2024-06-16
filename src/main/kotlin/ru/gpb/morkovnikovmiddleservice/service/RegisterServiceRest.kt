package ru.gpb.morkovnikovmiddleservice.service

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.ResourceAccessException
import org.springframework.web.client.RestClient

class RegisterServiceRest(private val restClient: RestClient): RegisterService {

    override fun registerUser(telegramUserId: Long, userName: String ): ResponseEntity<String> {
        val requestBody = mapOf(
            "userId" to telegramUserId,
            "userName" to userName
        )
        return try {
            val response= createRestRequest(requestBody)
            when (response.statusCodeValue) {
                204 -> ResponseEntity.status(HttpStatus.NO_CONTENT).body("Вы успешно зарегестрировались")
                409 -> ResponseEntity.status(HttpStatus.CONFLICT).body("Вы уже были зарегестрированны")
                else -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Извините, произошла непредвиденная ошибка")
            }
        } catch (e: ResourceAccessException) {
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Извините, сервис сейчас не работает")
        }
    }

    private fun createRestRequest(requestBody: Map<String, Any> ): ResponseEntity<String>{
        val registerEndpoint = "/v2/register"
        return restClient.post()
            .uri(registerEndpoint)
            .body(requestBody)
            .retrieve()
            .toEntity(String::class.java)
    }
}