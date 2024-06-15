package com.example.ps_back.domain.board.service

import com.example.ps_back.domain.board.entity.Board
import com.example.ps_back.domain.board.entity.enums.BoardType
import com.example.ps_back.domain.board.entity.repository.BoardRepository
import com.example.ps_back.domain.board.exception.BoardNotWriterException
import com.example.ps_back.domain.board.facade.BoardFacade
import com.example.ps_back.domain.board.presentation.dto.request.CreateBoardRequest
import com.example.ps_back.domain.board.presentation.dto.request.UpdateBoardRequest
import com.example.ps_back.domain.board.presentation.dto.response.BoardDetailResponse
import com.example.ps_back.domain.board.presentation.dto.response.BoardElement
import com.example.ps_back.domain.board.presentation.dto.response.BoardListResponse
import com.example.ps_back.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class BoardService(
    private val userFacade: UserFacade,
    private val boardFacade: BoardFacade,
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
                user = user,
                createDate = LocalDate.now(),
            )
        )
    }

    @Transactional
    public fun updateBoard(request: UpdateBoardRequest, boardId: Long) {
        val board = boardFacade.getByBoardId(boardId)

        if(!checkBoardWriter(board.id))
            throw BoardNotWriterException

        board.updateBoard(
            request.title,
            request.startDate,
            request.endDate,
            request.note,
            request.money,
            request.area,
        )
    }

    @Transactional(readOnly = true)
    public fun getBoardDetail(boardId: Long): BoardDetailResponse {
        val board = boardFacade.getByBoardId(boardId)

        return BoardDetailResponse(
            id = board.id,
            writerId = board.user.id,
            title = board.title,
            note = board.note,
            money = board.money,
            area = board.area,
            startDate = board.startDate,
            endDate = board.endDate,
        )
    }

    @Transactional(readOnly = true)
    public fun getBoardList(): BoardListResponse {
        val boardList = boardFacade.getBoardList()

        return BoardListResponse(boardList.map { board ->
            BoardElement(
                id = board.id,
                title = board.title,
                name = userFacade.getById(board.id).name,
                createDate = board.createDate,
            )
        })
    }

    @Transactional
    public fun deleteBoard(boardId: Long) {
        val board = boardFacade.getByBoardId(boardId)

        if(!checkBoardWriter(board.id))
            throw BoardNotWriterException

        boardFacade.deleteBoard(boardId)
    }

    private fun checkBoardWriter(boardId: Long): Boolean {
        val userId = userFacade.getCurrentUser().id
        return userId.equals(boardId)
    }
}
