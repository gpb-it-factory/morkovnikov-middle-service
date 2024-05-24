package ru.gpb.morkovnikovmiddleservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MorkovnikovMiddleServiceApplication

fun main(args: Array<String>) {
    runApplication<MorkovnikovMiddleServiceApplication>(*args)
}
