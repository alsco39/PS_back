package com.example.ps_back.global.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object ExpiredTokenException: PsException (
    ErrorCode.EXPIRED_TOKEN
)