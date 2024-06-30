package ru.gpb.morkovnikovmiddleservice.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.gpb.morkovnikovmiddleservice.dto.RegisterRequest
import ru.gpb.morkovnikovmiddleservice.service.UserService

@RestController
@RequestMapping("/v2/register")
class RegisterController(
    private val userService: UserService
) {

    @PostMapping
    fun doRegister(@RequestBody request: RegisterRequest): ResponseEntity<String> {
        val telegramUserId = request.telegramUserId
        val telegramUserName = request.telegramUserName
        return userService.registerUser(telegramUserId, telegramUserName)
    }
}