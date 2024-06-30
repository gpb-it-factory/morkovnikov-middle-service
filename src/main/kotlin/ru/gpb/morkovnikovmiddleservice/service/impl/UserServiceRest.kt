package ru.gpb.morkovnikovmiddleservice.service.impl

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.ResourceAccessException
import ru.gpb.morkovnikovmiddleservice.client.BackendServiceClient
import ru.gpb.morkovnikovmiddleservice.service.UserService
@Service
class UserServiceRest(private val restClient: BackendServiceClient): UserService {

    override fun registerUser(telegramUserId: Long, telegramUserName: String ): ResponseEntity<String> {
        return try {
            val response= restClient.registerUser(telegramUserId, telegramUserName)
            when (response.statusCodeValue) {
                204 -> ResponseEntity.status(HttpStatus.OK).body("Вы успешно зарегестрировались")
                409 -> ResponseEntity.status(HttpStatus.CONFLICT).body("Вы уже были зарегестрированны")
                else -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Извините, произошла непредвиденная ошибка")
            }
        } catch (e: ResourceAccessException) {
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Извините, сервис сейчас не работает")
        }
    }
    override fun checkUser(telegramUserId: Long): ResponseEntity<String>{
        return try {
            val response = restClient.checkUser(telegramUserId)
            when (response.statusCodeValue) {
                200 -> ResponseEntity.status(HttpStatus.OK).body(response.body)
                else -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Извините, произошла непредвиденная ошибка")
            }
        }catch (e: ResourceAccessException) {
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Извините, сервис сейчас не работает")
        }

    }
}