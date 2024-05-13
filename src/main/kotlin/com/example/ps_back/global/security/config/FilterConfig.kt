package com.example.ps_back.global.security.config

import com.example.ps_back.global.error.ExceptionFilter
import com.example.ps_back.global.security.jwt.JwtFilter
import com.example.ps_back.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig (
    val objectMapper: ObjectMapper,
    val jwtTokenProvider: JwtTokenProvider,
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        val tokenFilter = JwtFilter(jwtTokenProvider)
        val exceptionFilter = ExceptionFilter(objectMapper)

        builder.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(exceptionFilter, JwtFilter::class.java)
    }
}