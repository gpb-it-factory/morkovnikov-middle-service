package ru.gpb.morkovnikovmiddleservice.client

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class BackendServiceClientPlug:BackendServiceClient {
    override fun registerUser(telegramUserId: Long, telegramUserName: String): ResponseEntity<String> {
        val responseBody = "Пользователь ${telegramUserId} успешно зарегестрирован"
        return ResponseEntity(responseBody, HttpStatus.NO_CONTENT)
    }

    override fun createAccount(telegramUserId: Long): ResponseEntity<String> {
        val responseBody = "Вы успешно создали счет"
        return ResponseEntity(responseBody, HttpStatus.NO_CONTENT)
    }

    override fun checkUser(telegramUserId: Long): ResponseEntity<String> {
        val responseBody = "Данный пользователь существует"
        return ResponseEntity(responseBody, HttpStatus.NO_CONTENT)
    }
}