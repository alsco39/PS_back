package com.example.ps_back

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class PsBackApplication

fun main(args: Array<String>) {
    runApplication<PsBackApplication>(*args)
}
