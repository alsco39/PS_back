package com.example.ps_back.domain.user.presentation

import com.example.ps_back.domain.user.presentation.dto.request.UserSignUpRequest
import com.example.ps_back.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    private val userService: UserService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public fun signUp(@RequestBody request: UserSignUpRequest) {
        userService.userSignUp(request)
    }
}