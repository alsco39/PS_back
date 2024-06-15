package com.example.ps_back.global.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val filterConfig: FilterConfig,
) {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            csrf { disable() }
            formLogin { disable() }

            authorizeHttpRequests {
                authorize(HttpMethod.POST, "/users/signup", permitAll)
                authorize(HttpMethod.POST, "/users/signin", permitAll)
                authorize(HttpMethod.POST, "/images/upload", permitAll)
                authorize(anyRequest, permitAll)
            }

            sessionManagement { sessionCreationPolicy = SessionCreationPolicy.STATELESS }
        }

        http.apply(filterConfig)

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
