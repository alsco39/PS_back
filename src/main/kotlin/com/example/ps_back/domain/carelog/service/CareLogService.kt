package com.example.ps_back.domain.carelog.service

import com.example.ps_back.domain.care.facade.CareFacade
import com.example.ps_back.domain.carelog.entity.repository.CareLogRepository
import com.example.ps_back.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CareLogService(
    private val careLogRepository: CareLogRepository,
    private val userFacade: UserFacade,
    private val careFacade: CareFacade,
) {


}