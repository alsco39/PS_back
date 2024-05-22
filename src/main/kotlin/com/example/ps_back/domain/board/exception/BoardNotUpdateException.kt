package com.example.ps_back.domain.board.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object BoardNotUpdateException: PsException(
    ErrorCode.FEED_NOT_UPDATE
)