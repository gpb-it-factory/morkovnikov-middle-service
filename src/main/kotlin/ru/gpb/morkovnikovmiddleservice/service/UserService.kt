package ru.gpb.morkovnikovmiddleservice.service

import org.springframework.http.ResponseEntity


interface UserService {
    fun registerUser(telegramUserId: Long, userName: String): ResponseEntity<String>
    fun checkUser(telegramUserId: Long): ResponseEntity<String>
}