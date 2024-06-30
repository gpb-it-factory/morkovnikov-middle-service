package ru.gpb.morkovnikovmiddleservice.client

import org.springframework.http.ResponseEntity

interface BackendServiceClient {
    fun registerUser(telegramUserId: Long, telegramUserName: String): ResponseEntity<String>
    fun createAccount(telegramUserId: Long): ResponseEntity<String>
    fun checkUser(telegramUserId: Long): ResponseEntity<String>
}