package com.example.ps_back.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
){

    EXPIRED_TOKEN(401, "Expired Token."),
    INVALID_TOKEN(401, "Invalid Token."),

    USER_ALREADY_EXIST(409, "User Already Exist."),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error.");
}