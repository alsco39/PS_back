package com.example.ps_back.domain.board.facade

import com.example.ps_back.domain.board.entity.Board
import com.example.ps_back.domain.board.entity.repository.BoardRepository
import com.example.ps_back.domain.board.exception.BoardNotFoundException
import com.example.ps_back.domain.board.presentation.dto.response.BoardElement
import org.springframework.stereotype.Component

@Component
class BoardFacade(
    private val boardRepository: BoardRepository
) {

    fun getByBoardId(boardId: Long): Board {
        return boardRepository.findById(boardId).orElseThrow { BoardNotFoundException }
    }

    fun getBoardList(): List<Board> {
        return boardRepository.findAllByOrderByCreateDate()
    }

    fun deleteBoard(boardId: Long) {
        boardRepository.deleteBoardById(boardId)
    }
}