package com.example.ps_back.domain.care.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object CareNotDeleteException: PsException (
    ErrorCode.CARE_NOT_DELETE
)