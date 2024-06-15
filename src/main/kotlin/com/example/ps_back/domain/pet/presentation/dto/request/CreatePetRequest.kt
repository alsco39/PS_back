package com.example.ps_back.domain.pet.presentation.dto.request

import com.example.ps_back.domain.pet.entity.enums.Gender
import com.example.ps_back.domain.pet.entity.enums.Tendency

data class CreatePetRequest(
    val name: String,
    val gender: Gender,
    val age: Int,
    val tendency: Tendency,
    val profile: String,
)
