package com.example.ps_back.domain.board.presentation.dto.response

import java.time.LocalDate

data class BoardElement(
    val id: Long,
    val title: String,
    val name: String,
    val createDate: LocalDate
)
