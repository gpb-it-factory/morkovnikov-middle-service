package ru.gpb.morkovnikovmiddleservice.service

import org.springframework.http.ResponseEntity


interface RegisterService {
    fun registerUser(telegramUserId: Long, userName: String): ResponseEntity<String>
}