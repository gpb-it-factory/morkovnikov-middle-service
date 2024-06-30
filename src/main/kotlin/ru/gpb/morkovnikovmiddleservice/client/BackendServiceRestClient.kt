package ru.gpb.morkovnikovmiddleservice.client

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
@Component
class BackendServiceRestClient(private val restClient: RestClient): BackendServiceClient {

    private fun createPostRequest(endpoint: String, requestBody: Map<String, Any>): ResponseEntity<String> {

        return restClient.post()
            .uri(endpoint)
            .body(requestBody)
            .retrieve()
            .toEntity(String::class.java)
    }
    private fun createGetRequest(endpoint: String) : ResponseEntity<String> {
        return restClient.get()
            .uri(endpoint)
            .retrieve()
            .toEntity(String::class.java)
    }

    override fun registerUser(telegramUserId: Long, telegramUserName: String): ResponseEntity<String> {
        val registerEndpoint = "/v2/register"

        val requestBody = mapOf(
            "userId" to telegramUserId,
            "userName" to telegramUserName
        )

        return createPostRequest(registerEndpoint, requestBody)
    }

    override fun createAccount(telegramUserId: Long):ResponseEntity<String> {
        val registerEndpoint = "/v2/users/${telegramUserId}/accounts"
        val requestBody = mapOf("userId" to telegramUserId)
        return createPostRequest(registerEndpoint, requestBody)
    }

    override fun checkUser(telegramUserId: Long): ResponseEntity<String>{
        val checkUserEndpoint = "/v2/users/${telegramUserId}"
        return createGetRequest(checkUserEndpoint)
    }


}