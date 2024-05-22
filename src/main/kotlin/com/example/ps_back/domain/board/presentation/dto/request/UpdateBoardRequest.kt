package com.example.ps_back.domain.board.presentation.dto.request

import java.time.LocalDate

data class UpdateBoardRequest (
    val title: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val note: String,
    val money: Int,
    val area: String,
)