package ru.gpb.morkovnikovmiddleservice.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.gpb.morkovnikovmiddleservice.dto.RegisterRequest
import ru.gpb.morkovnikovmiddleservice.service.AccountService
import ru.gpb.morkovnikovmiddleservice.service.UserService

@RestController
@RequestMapping("/v2/account")
class CreateAccountController(private val accountService: AccountService) {
    @PostMapping
    fun createAccount(@RequestBody request: RegisterRequest): ResponseEntity<String> {
        val telegramUserId = request.telegramUserId
        return accountService.createAccount(telegramUserId)
    }
}