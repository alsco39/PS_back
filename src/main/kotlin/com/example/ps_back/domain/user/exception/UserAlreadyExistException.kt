package com.example.ps_back.domain.user.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object UserAlreadyExistException : PsException(
    ErrorCode.USER_ALREADY_EXIST
)