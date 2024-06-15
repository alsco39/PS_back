package com.example.ps_back.global.config.s3

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "aws")
data class S3Properties(
    val accessKey: String,
    val secretKey: String,
    val bucket: String?,
    val url: String?,
    val static: String?,
)