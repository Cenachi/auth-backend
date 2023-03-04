package com.auth.api.controller

import com.auth.api.dto.LoginDto
import com.auth.api.dto.RegisterDto
import com.auth.api.model.User
import com.auth.api.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("api/auth")
class AuthController{

    @Autowired
    private lateinit var service : UserService

    @GetMapping("/test")
    fun teste():ResponseEntity<String>{
        return ResponseEntity.ok("test")
    }

    @PostMapping("/register")
    fun register(@RequestBody body: RegisterDto): ResponseEntity<User>{
        return ResponseEntity.ok(service.register(body))
    }

    @PostMapping("/login", consumes = ["application/json"])
    fun login(@RequestBody body: LoginDto): ResponseEntity<Any>{
        return try {
            ResponseEntity.ok(service.login(body))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(e.message)
        }
    }
}