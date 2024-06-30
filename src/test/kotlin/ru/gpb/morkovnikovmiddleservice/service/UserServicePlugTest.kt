package ru.gpb.morkovnikovmiddleservice.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.gpb.morkovnikovmiddleservice.client.BackendServiceClientPlug
import ru.gpb.morkovnikovmiddleservice.service.impl.UserServiceRest
import kotlin.random.Random

class UserServicePlugTest {

    private val backendServiceClientPlug = BackendServiceClientPlug()
    private val registerService = UserServiceRest(backendServiceClientPlug)
    @Test
    @DisplayName("Успешная регистрация пользователя")
    fun successRegisterUser() {
        val telegramUserId = Random.nextLong()
        val testUserName = "Pepega1"

        val result = registerService.registerUser(telegramUserId, testUserName).body

        Assertions.assertEquals("Вы успешно зарегестрировались", result)
    }
}