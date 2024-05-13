package com.example.ps_back.global.security.auth

import com.example.ps_back.domain.user.entity.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository,
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user = userRepository.findUserByAccountId(accountId) ?: throw UsernameNotFoundException(accountId)
        return AuthDetails(accountId, user.role)
    }
}