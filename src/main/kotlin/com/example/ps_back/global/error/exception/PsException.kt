package com.example.ps_back.global.error.exception

import com.example.ps_back.global.security.ErrorCode

abstract class PsException(
    val errorCode: ErrorCode,
) : RuntimeException() {

    val status: Int get() = errorCode.status
    override val message: String get() = errorCode.message
}