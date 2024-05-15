package com.example.ps_back.domain.user.presentation.dto.request

data class UserSignUpRequest(
    val name: String,
    val phone: String,
    val accountId: String,
    val password: String,
)
