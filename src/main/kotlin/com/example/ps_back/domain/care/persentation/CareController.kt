package com.example.ps_back.domain.care.persentation

import com.example.ps_back.domain.care.service.CareService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cares")
@RestController
class CareController(
    private val careService: CareService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{board-id}")
    public fun createPetCare(@PathVariable(name = "board-id") boardId: Long) {
        careService.createPetCare(boardId)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{board-id}")
    public fun deletePetCare(@PathVariable(name = "board-id") boardId: Long) {
        careService.deletePetCare(boardId)
    }
}