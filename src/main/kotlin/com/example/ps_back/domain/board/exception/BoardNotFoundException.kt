package com.example.ps_back.domain.board.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object BoardNotFoundException: PsException(
    ErrorCode.BOARD_NOT_FOUND
)