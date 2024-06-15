package com.example.ps_back.domain.care.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object CareNotFoundException: PsException (
    ErrorCode.CARE_NOT_FOUND
)