package com.example.ps_back.domain.care.entity.repository

import com.example.ps_back.domain.care.entity.Care
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CareRepository : CrudRepository<Care, Long> {
    fun findCareBy
}