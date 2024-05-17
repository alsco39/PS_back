package com.example.ps_back.domain.board.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class CreateBoardRequest(
    @field: NotBlank
    val title: String,
    @field: NotBlank
    val period: LocalDate,
    @field: NotBlank
    val note: String,
    @field: NotBlank
    val money: Int,
    @field: NotBlank
    val area: String,
    @field: NotBlank
    val startDate: LocalDate,
    @field: NotBlank
    val endDate: LocalDate,
)
