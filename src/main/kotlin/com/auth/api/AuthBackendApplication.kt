package com.auth.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class AuthBackendApplication
fun main(args: Array<String>) {
    runApplication<AuthBackendApplication>(*args)
}
