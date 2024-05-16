package com.example.ps_back.domain.user.service

import com.example.ps_back.domain.user.entity.User
import com.example.ps_back.domain.user.entity.enums.Authority
import com.example.ps_back.domain.user.entity.repository.UserRepository
import com.example.ps_back.domain.user.exception.PasswordMisMatchedException
import com.example.ps_back.domain.user.exception.UserAlreadyExistException
import com.example.ps_back.domain.user.exception.UserNotFoundException
import com.example.ps_back.domain.user.presentation.dto.request.UserSignInRequest
import com.example.ps_back.domain.user.presentation.dto.request.UserSignUpRequest
import com.example.ps_back.domain.user.presentation.dto.response.TokenResponse
import com.example.ps_back.global.security.jwt.JwtProperties
import com.example.ps_back.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtProperties: JwtProperties,
) {

    @Transactional
    public fun userSignUp(request: UserSignUpRequest) {
        val checkExistUser = userRepository.existsUserByAccountId(request.accountId)
        if(checkExistUser) throw UserAlreadyExistException

        userRepository.save(
            User(
                name = request.name,
                phone = request.phone,
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                role = Authority.USER
            )
        )
    }

    @Transactional
    public fun userSignIn(request: UserSignInRequest): TokenResponse {
        val user = userRepository.findUserByAccountId(request.accountId) ?: throw UserNotFoundException

        if(!passwordEncoder.matches(request.password, user.password))
            throw PasswordMisMatchedException

        val accessToken: String = jwtTokenProvider.createAccessToken(request.accountId)

        return TokenResponse(
            accessToken = accessToken,
            expiredAt = LocalDateTime.now().plusSeconds(jwtProperties.accessExp),
            authority = user.role,
        )
    }
}