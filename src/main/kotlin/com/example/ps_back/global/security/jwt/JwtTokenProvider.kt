package com.example.ps_back.global.security.jwt

import com.example.ps_back.global.exception.ExpiredTokenException
import com.example.ps_back.global.exception.InvalidTokenException
import com.example.ps_back.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.apache.naming.SelectorContext.prefix
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*


@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {

    public fun createAccessToken(accountId: String): String {
        return generateToken(accountId, "access", jwtProperties.accessExp)
    }

    private fun generateToken(accountId: String, typ: String, exp: Long): String {
        return jwtProperties.prefix + Jwts.builder()
            .setSubject(accountId)
            .claim("typ", typ)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .setIssuedAt(Date())
            .compact()
    }

    public fun getAuthentication(token: String): Authentication {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getAccountId(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getAccountId(token: String) =
        getClaims(token).subject

    private fun getClaims(token: String): Claims {
        try {
            return Jwts
                .parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray()))
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredTokenException) {
            throw ExpiredTokenException
        } catch (e: InvalidTokenException) {
            throw InvalidTokenException
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(jwtProperties.header)
        if (bearer != null && bearer.startsWith(prefix) && bearer.length > prefix.length + 1) return bearer.substring(
            prefix.length + 1
        )
        return null
    }
}