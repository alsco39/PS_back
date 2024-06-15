package com.example.ps_back.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
){
    PASSWORD_MISMATCHED(400, "Password Mis Matched."),
    FILE_IS_EMPTY(400, "File is Empty"),
    FILE_SAVE_FAILED(400, "File Save Failed"),

    EXPIRED_TOKEN(401, "Expired Token."),
    INVALID_TOKEN(401, "Invalid Token."),
    BOARD_NOT_WRITER(401, "Board Not Writer."),
    CARE_NOT_DELETE(401, "Care Not Delete."),

    USER_NOT_FOUND(404, "User Not Found."),
    BOARD_NOT_FOUND(404, "Board Not Found."),
    PET_NOT_FOUND(404, "Pet Not Found."),
    CARE_NOT_FOUND(404, "Care Not Found."),

    USER_ALREADY_EXIST(409, "User Already Exist."),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error.");
}