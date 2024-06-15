package com.example.ps_back.domain.pet.service

import com.example.ps_back.domain.pet.entity.Pet
import com.example.ps_back.domain.pet.entity.repository.PetRepository
import com.example.ps_back.domain.pet.presentation.dto.request.CreatePetRequest
import com.example.ps_back.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PetService(
    private val userFacade: UserFacade,
    private val petRepository: PetRepository,
) {

    @Transactional
    public fun createPet(request: CreatePetRequest) {
        val user = userFacade.getCurrentUser()

        petRepository.save(
            Pet(
                user = user,
                name = request.name,
                gender = request.gender,
                age = request.age,
                tendency = request.tendency,
                profile = request.profile,
            )
        )
    }
}