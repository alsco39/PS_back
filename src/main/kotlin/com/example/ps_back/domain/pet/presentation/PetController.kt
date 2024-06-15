package com.example.ps_back.domain.pet.presentation

import com.example.ps_back.domain.pet.presentation.dto.request.CreatePetRequest
import com.example.ps_back.domain.pet.service.PetService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/pets")
@RestController
class PetController(
    private val petService: PetService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public fun createPet(@RequestBody request: CreatePetRequest) {
        petService.createPet(request)
    }
}