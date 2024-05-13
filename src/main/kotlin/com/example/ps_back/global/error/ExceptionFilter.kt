package com.example.ps_back.global.error

import com.example.ps_back.global.error.exception.PsException
import com.example.ps_back.global.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class ExceptionFilter(
    private val objectMapper: ObjectMapper,
) : OncePerRequestFilter() {

    @Throws(IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (exception: Exception) {
            exception.printStackTrace()
            when (exception) {
                is PsException -> writeErrorCode(exception, response)
                else -> writeErrorCode(InternalServerErrorException, response)
            }
        }
    }

    @Throws(IOException::class)
    private fun writeErrorCode(exception: PsException, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(exception)

        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = errorResponse.status
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}