package com.example.ps_back

import com.example.ps_back.global.config.s3.S3Properties
import com.example.ps_back.global.security.jwt.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableConfigurationProperties(
    S3Properties::class,
    JwtProperties::class,
)
@ConfigurationPropertiesScan
@EnableJpaAuditing
@SpringBootApplication
class PsBackApplication

fun main(args: Array<String>) {
    runApplication<PsBackApplication>(*args)
}
