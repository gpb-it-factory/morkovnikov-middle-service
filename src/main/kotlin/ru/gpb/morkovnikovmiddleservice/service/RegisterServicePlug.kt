package ru.gpb.morkovnikovmiddleservice.service

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

//Класс - заглушка, имитирует отправку запроса на backend сервер и получение от него кода 204 (Пользователь создан)
    @Service
    class RegisterServicePlug: RegisterService {
        override fun registerUser(telegramUserId: Long, telegramUserName: String): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("Пользователь ${telegramUserId} успешно зарегестрирован")

    }

}