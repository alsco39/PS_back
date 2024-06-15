package com.example.ps_back.domain.pet.entity.repository

import com.example.ps_back.domain.pet.entity.Pet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : CrudRepository<Pet, Long> {
    fun findPetByUserId(userId: Long): Pet?
}