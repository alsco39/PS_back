package com.example.ps_back.domain.user.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object UserNotFoundException : PsException (
    ErrorCode.USER_NOT_FOUND
)