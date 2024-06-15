package com.example.ps_back.domain.board.presentation.dto.response

import java.time.LocalDate

data class BoardDetailResponse (
    val id: Long,
    val writerId: Long,
    val title: String,
    val note: String,
    val money: Int,
    val area: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
)