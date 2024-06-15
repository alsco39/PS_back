package com.example.ps_back.domain.care.service

import com.example.ps_back.domain.board.facade.BoardFacade
import com.example.ps_back.domain.care.entity.Care
import com.example.ps_back.domain.care.entity.repository.CareRepository
import com.example.ps_back.domain.care.exception.CareNotDeleteException
import com.example.ps_back.domain.care.facade.CareFacade
import com.example.ps_back.domain.pet.facade.PetFacade
import com.example.ps_back.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CareService(
    private val userFacade: UserFacade,
    private val boardFacade: BoardFacade,
    private val petFacade: PetFacade,
    private val careRepository: CareRepository,
    private val careFacade: CareFacade,
) {

    @Transactional
    public fun createPetCare(boardId: Long) {
        val user = userFacade.getCurrentUser()
        val board = boardFacade.getByBoardId(boardId)
        val pet = petFacade.getPetByUserId(board.user.id)

        careRepository.save(
            Care(
                pet = pet,
                user = user,
                isTrue = false,
            )
        )
    }

    @Transactional
    public fun deletePetCare(petCareId: Long) {
        val user = userFacade.getCurrentUser()
        val care = careFacade.getById(petCareId)

        if(user.id != care.user.id)
            throw CareNotDeleteException

        careFacade.deleteById(petCareId)
    }
}