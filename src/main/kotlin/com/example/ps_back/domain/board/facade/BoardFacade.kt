package com.example.ps_back.domain.board.facade

import com.example.ps_back.domain.board.entity.Board
import com.example.ps_back.domain.board.entity.repository.BoardRepository
import com.example.ps_back.domain.board.exception.BoardNotFoundException
import org.springframework.stereotype.Component
import java.util.*

@Component
class BoardFacade(
    private val boardRepository: BoardRepository
) {

    fun getByBoardId(boardId: Long): Board {
        return boardRepository.findById(boardId).orElseThrow { BoardNotFoundException }
    }
}