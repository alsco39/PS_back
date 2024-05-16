package com.example.ps_back.domain.user.presentation.dto.request

data class UserSignInRequest (
    val accountId: String,
    val password: String,
)