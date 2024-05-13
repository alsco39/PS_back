package com.example.ps_back.global.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object InternalServerErrorException : PsException(
    ErrorCode.INTERNAL_SERVER_ERROR
)