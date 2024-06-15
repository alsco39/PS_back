package com.example.ps_back.global.utils.s3.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object FileIsEmptyException: PsException(
    ErrorCode.FILE_IS_EMPTY
)