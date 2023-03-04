package com.auth.api.dto

import com.auth.api.model.User

class ResponseDto (
    val token : String,
    val user : User
)