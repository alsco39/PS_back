package com.example.ps_back.global.security.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**")
            .allowedHeaders("*")
            .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE")
            .allowedOrigins("http://localhost:3000", "http://localhost:3001")
    }
}