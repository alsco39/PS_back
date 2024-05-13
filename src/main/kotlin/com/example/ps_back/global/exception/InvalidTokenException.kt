package com.example.ps_back.global.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object InvalidTokenException: PsException(
    ErrorCode.INVALID_TOKEN,
)