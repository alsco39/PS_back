package com.example.ps_back.global.error

import com.example.ps_back.global.error.exception.PsException

class ErrorResponse(
    val status: Int,
    val message: String,
) {
    companion object {
        fun of(e: PsException): ErrorResponse {
            return ErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }
}