package com.example.ps_back.global.utils.s3.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object FileSaveFailedException: PsException(
    ErrorCode.FILE_SAVE_FAILED
)