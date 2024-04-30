package com.example.ps_back.global.enums

import lombok.AllArgsConstructor

@AllArgsConstructor
enum class Authority(
    private var value: String
) {
    USER("ROLE_USER"),
    PET_SITTER("ROLE_PET_SITTER")
}