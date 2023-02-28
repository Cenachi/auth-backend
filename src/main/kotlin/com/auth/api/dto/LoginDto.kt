package com.auth.api.dto

import lombok.Data

@Data
data class LoginDto(
    val email: String,
    val password: String
)