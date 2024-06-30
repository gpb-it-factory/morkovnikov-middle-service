package ru.gpb.morkovnikovmiddleservice.service

import org.springframework.http.ResponseEntity

interface AccountService {
    fun createAccount(telegramUserId: Long): ResponseEntity<String>
}