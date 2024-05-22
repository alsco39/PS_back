package com.example.ps_back.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
){
    PASSWORD_MISMATCHED(400, "Password Mis Matched."),

    EXPIRED_TOKEN(401, "Expired Token."),
    INVALID_TOKEN(401, "Invalid Token."),
    FEED_NOT_UPDATE(401, "Feed Not Update."),

    USER_NOT_FOUND(404, "User Not Found."),
    BOARD_NOT_FOUND(404, "Board Not Found."),

    USER_ALREADY_EXIST(409, "User Already Exist."),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error.");
}