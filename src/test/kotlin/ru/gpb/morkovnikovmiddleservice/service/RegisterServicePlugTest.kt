package ru.gpb.morkovnikovmiddleservice.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RegisterServicePlugTest {

    private val registerService = RegisterServicePlug()
    @Test
    @DisplayName("Успешная регистрация пользователя")
    fun successRegisterUser() {
        val telegramUserId = Random.nextLong()
        val testUserName = "Pepega1"

        val result = registerService.registerUser(telegramUserId, testUserName).body


        Assertions.assertEquals("Пользователь ${telegramUserId} успешно зарегестрирован", result)
    }
}