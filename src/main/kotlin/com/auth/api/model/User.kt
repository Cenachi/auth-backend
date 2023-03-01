package com.auth.api.model

import jakarta.persistence.*
import lombok.Data
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
@Data
@Table(name= "user")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column
    var name: String,
    @Column
    var email: String,
    @Column
    var password: String

){
    fun encoderPassword(){
        val passwordEncoder = BCryptPasswordEncoder()
        this.password = passwordEncoder.encode(password)
    }

    fun comparePassword(password: String): Boolean{
        return BCryptPasswordEncoder().matches(password,this.password)
    }
}