package ru.gpb.morkovnikovmiddleservice.registration.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.gpb.morkovnikovmiddleservice.registration.application.implement.service.RegisterServicePlug

@RestController
@RequestMapping("/register")
class RegisterController(
    private val registerService: RegisterServicePlug
) {

    @PostMapping
    fun doRegister(@RequestBody requestBody: Map<String, Long>): ResponseEntity<String> {
        val telegramUserId = requestBody["telegramUserId"]
        // Использую !! Потому что запрос может прийти только с уровня телеграм бота
        // и если не получиться взять userId ошибка выпадет на уровне telegram-bot сервиса.
        return registerService.registerUser(telegramUserId!!)
    }
}