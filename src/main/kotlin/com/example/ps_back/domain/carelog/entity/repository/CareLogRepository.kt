package com.example.ps_back.domain.carelog.entity.repository

import com.example.ps_back.domain.carelog.entity.CareLog
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CareLogRepository : CrudRepository<CareLog, Long>