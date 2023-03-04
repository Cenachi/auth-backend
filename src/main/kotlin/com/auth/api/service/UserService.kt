package com.auth.api.service

import com.auth.api.dto.LoginDto
import com.auth.api.dto.RegisterDto
import com.auth.api.dto.ResponseDto
import com.auth.api.model.User
import com.auth.api.repositorie.UserRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {

    @Autowired
    private  lateinit var repository: UserRepository

    fun register(register:RegisterDto):User{
        val userExists: Optional<User> = repository.findByEmail(register.email)
        if(userExists.isPresent) {
            throw Exception("User already exists")
        }
        val user = User(0,register.name,register.email,register.password)

        user.encoderPassword()

        return repository.save(user)
    }

    fun login(login:LoginDto):ResponseDto{
        val userExists = repository.findByEmail(login.email)

        if(!userExists.isPresent){
            throw Exception("User not found")
        }
        var user: User = userExists.get()
        if(!user.comparePassword(login.password)){
            throw Exception("Password is incorrect")
        }

        val issuer = user.id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 *24 *1000))
            .signWith(SignatureAlgorithm.HS256, "secret")
            .compact()

        return ResponseDto(jwt,user)
    }
}
