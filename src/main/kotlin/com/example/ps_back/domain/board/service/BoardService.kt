package com.example.ps_back.domain.board.service

import com.example.ps_back.domain.board.entity.Board
import com.example.ps_back.domain.board.entity.enums.BoardType
import com.example.ps_back.domain.board.entity.repository.BoardRepository
import com.example.ps_back.domain.board.presentation.dto.request.CreateBoardRequest
import com.example.ps_back.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private val userFacade: UserFacade,
    private val boardRepository: BoardRepository,
) {

    @Transactional
    public fun createBoard(request: CreateBoardRequest) {
        val user = userFacade.getCurrentUser()

        boardRepository.save(
            Board(
                title = request.title,
                endDate = request.endDate,
                note = request.note,
                type = BoardType.APPLY,
                money = request.money,
                area = request.area,
                startDate = request.startDate,
                user = user
            )
        )
    }

}