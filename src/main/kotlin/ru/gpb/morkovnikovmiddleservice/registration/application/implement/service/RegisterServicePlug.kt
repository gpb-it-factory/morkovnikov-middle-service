package ru.gpb.morkovnikovmiddleservice.registration.application.implement.service

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.gpb.morkovnikovmiddleservice.registration.application.RegisterService

//Класс - заглушка, имитирует отправку запроса на backend сервер и получение от него кода 204 (Пользователь создан)
@Service
class RegisterServicePlug: RegisterService {
    override fun registerUser(telegramUserId: Long): ResponseEntity<String> {
        /*
           Отправим запрос с регистрацией пользователя в backend
           sendPostRequest(telegramUserId)
         */
        return ResponseEntity.status(HttpStatus.OK).body("Пользователь ${telegramUserId} успешно зарегестрирован")

    }
    private fun sendPostRequest(telegramUserId: Long) {
        // TODO написать отправку запроса на сервер

    }

}