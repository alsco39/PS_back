package com.example.ps_back.domain.user.facade

import com.example.ps_back.domain.user.entity.User
import com.example.ps_back.domain.user.entity.repository.UserRepository
import com.example.ps_back.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        val accountId: String = SecurityContextHolder.getContext().authentication.name
        return getByAccountId(accountId)
    }

    fun getByAccountId(accountId: String): User {
        return userRepository.findUserByAccountId(accountId) ?: throw UserNotFoundException
    }

}