package ru.gpb.morkovnikovmiddleservice.registration.application

import org.springframework.http.ResponseEntity


interface RegisterService {
    fun registerUser(telegramUserId: Long): ResponseEntity<String>
}