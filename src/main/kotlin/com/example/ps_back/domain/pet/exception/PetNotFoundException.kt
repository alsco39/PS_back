package com.example.ps_back.domain.pet.exception

import com.example.ps_back.global.error.exception.ErrorCode
import com.example.ps_back.global.error.exception.PsException

object PetNotFoundException: PsException (
    ErrorCode.PET_NOT_FOUND
)