package com.auth.api.repositorie

import com.auth.api.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Int> {
    fun findByEmail(email: String): Optional<User>
}