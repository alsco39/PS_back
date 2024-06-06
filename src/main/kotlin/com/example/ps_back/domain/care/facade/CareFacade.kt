package com.example.ps_back.domain.care.facade

import com.example.ps_back.domain.care.entity.Care
import com.example.ps_back.domain.care.entity.repository.CareRepository
import com.example.ps_back.domain.care.exception.CareNotFoundException
import org.springframework.stereotype.Component

@Component
class CareFacade(
    private val careRepository: CareRepository,
) {

    fun deleteById(id: Long) {
        careRepository.deleteById(id)
    }

    fun getById(id: Long): Care {
        return careRepository.findById(id).orElseThrow{ CareNotFoundException}
    }
}