package com.example.ps_back.domain.user.presentation.dto.response

import com.example.ps_back.domain.user.entity.enums.Authority
import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val expiredAt: LocalDateTime,
    val authority: Authority,
)
