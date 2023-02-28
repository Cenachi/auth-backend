package com.auth.api.controller

import com.auth.api.dto.RegisterDto
import com.auth.api.model.User
import com.auth.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("api/auth")
class AuthController(private val service : UserService){

//    @Autowired
//    private lateinit var service : UserService

    @GetMapping("/test")
    fun teste():ResponseEntity<String>{
        return ResponseEntity.ok("test")
    }

    @PostMapping("/register")
    fun register(@RequestBody login: RegisterDto): ResponseEntity<User>{
        return ResponseEntity.ok(service.register(login))
    }

    @PostMapping("/login")
    fun login(){

    }

}