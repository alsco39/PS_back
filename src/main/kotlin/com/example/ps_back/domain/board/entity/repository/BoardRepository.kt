package com.example.ps_back.domain.board.entity.repository

import com.example.ps_back.domain.board.entity.Board
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : CrudRepository<Board, Long>