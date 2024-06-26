package com.example.ps_back.domain.board.presentation

import com.example.ps_back.domain.board.presentation.dto.request.CreateBoardRequest
import com.example.ps_back.domain.board.presentation.dto.request.UpdateBoardRequest
import com.example.ps_back.domain.board.presentation.dto.response.BoardDetailResponse
import com.example.ps_back.domain.board.presentation.dto.response.BoardListResponse
import com.example.ps_back.domain.board.service.BoardService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/boards")
@RestController
class BoardController(
    private val boardService: BoardService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public fun createBoard(@RequestBody @Valid request: CreateBoardRequest) {
        boardService.createBoard(request)
    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PatchMapping("/update/{board-id}")
//    public fun updateBoard(@PathVariable("board-id") boardId: Long, @RequestBody @Valid request: UpdateBoardRequest) {
//        boardService.updateBoard(request, boardId)
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{board-id}")
    public fun getBoardDetail(@PathVariable(name = "board-id") boardId: Long): BoardDetailResponse {
        return boardService.getBoardDetail(boardId)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public fun getBoardList(): BoardListResponse {
        return boardService.getBoardList()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{board-id}")
    public fun deleteBoard(@PathVariable(name = "board-id") boardId: Long) {
        boardService.deleteBoard(boardId)
    }
}