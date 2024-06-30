package ru.gpb.morkovnikovmiddleservice.service.impl

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.ResourceAccessException
import ru.gpb.morkovnikovmiddleservice.client.BackendServiceClient
import ru.gpb.morkovnikovmiddleservice.service.AccountService
import ru.gpb.morkovnikovmiddleservice.service.UserService

@Service
class AccountServiceRest(private val backendServiceClient: BackendServiceClient,
    private val userService: UserService
) : AccountService {
    override fun createAccount(telegramUserId: Long): ResponseEntity<String>{
        if(userService.checkUser(telegramUserId).statusCode != HttpStatus.OK)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Вы не зарегистрировались. Используйте /register что бы зарегистрироваться")

        return try {
            val response= backendServiceClient.createAccount(telegramUserId)
            when (response.statusCodeValue) {
                204 -> ResponseEntity.status(HttpStatus.OK).body("Счёт создан")
                409 -> ResponseEntity.status(HttpStatus.CONFLICT).body("Вы уже создали такой счет")
                else -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Извините, произошла непредвиденная ошибка")
            }
        } catch (e: ResourceAccessException) {
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Извините, сервис сейчас не работает")
        }
    }
}