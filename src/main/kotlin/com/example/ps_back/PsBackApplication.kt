package com.example.ps_back

import com.example.ps_back.global.security.jwt.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableConfigurationProperties(JwtProperties::class)
@EnableJpaAuditing
@SpringBootApplication
class PsBackApplication

fun main(args: Array<String>) {
    runApplication<PsBackApplication>(*args)
}
