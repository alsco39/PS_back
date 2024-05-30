package com.example.ps_back.domain.board.entity.repository

import com.example.ps_back.domain.board.entity.Board
import com.example.ps_back.domain.board.presentation.dto.response.BoardElement
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : CrudRepository<Board, Long> {
    fun findAllByOrderByCreateDate(): List<BoardElement>

    fun deleteBoardById(id: Long)
}
