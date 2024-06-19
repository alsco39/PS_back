package com.example.ps_back.domain.pet.presentation.dto.request

import com.example.ps_back.domain.pet.entity.enums.Gender

data class CreatePetRequest(
    val name: String,
    val gender: Gender,
    val age: Int,
    val tendency: String,
    val profile: String,
)
