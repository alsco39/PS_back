package com.example.ps_back.domain.user.service

import com.example.ps_back.domain.user.entity.User
import com.example.ps_back.domain.user.entity.enums.Authority
import com.example.ps_back.domain.user.entity.repository.UserRepository
import com.example.ps_back.domain.user.exception.UserAlreadyExistException
import com.example.ps_back.domain.user.presentation.dto.request.UserSignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    @Transactional(readOnly = true)
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
}