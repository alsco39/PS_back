package com.example.ps_back.domain.pet.facade

import com.example.ps_back.domain.pet.entity.Pet
import com.example.ps_back.domain.pet.entity.repository.PetRepository
import com.example.ps_back.domain.pet.exception.PetNotFoundException
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Component

@Component
class PetFacade(
    private val petRepository: PetRepository,
) {

    fun getPetByUserId(userId: Long): Pet {
        return petRepository.findPetByUserId(userId) ?: throw PetNotFoundException
    }
}