package com.example.migracion

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MigracionApplication

fun main(args: Array<String>) {
	runApplication<MigracionApplication>(*args)
}
