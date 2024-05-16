package com.example.ps_back.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    var secretKey: String,
    val accessExp: Long,
    val header: String,
    val prefix: String,
)