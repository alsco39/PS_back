package com.example.ps_back.domain.user.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object PasswordMisMatchedException : PsException(
    ErrorCode.PASSWORD_MISMATCHED
)