package com.example.ps_back.global.security.auth

import com.example.ps_back.domain.user.entity.enums.Authority
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Collections

class AuthDetails(
    private val accountId: String,
    private val authority: Authority
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return Collections.singletonList(SimpleGrantedAuthority(authority.name));
    }

    override fun getPassword(): String? = null

    override fun getUsername(): String = accountId

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}