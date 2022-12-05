package com.sparta.basic_crud_10.controller;

import com.sparta.basic_crud_10.dto.BoardListResponseDto;
import com.sparta.basic_crud_10.dto.BoardRequestDto;
import com.sparta.basic_crud_10.dto.BoardResponseDto;
import com.sparta.basic_crud_10.dto.ResponseDto;
import com.sparta.basic_crud_10.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController //RestController 구글링!!
@RequestMapping("/api")
@RequiredArgsConstructor // RequiredArgsConstructor 구글링!!
public class BoardController {

    private final BoardService boardService;

    //게시글 작성 API
    //
    @PostMapping("/post/board")
    public ResponseDto postBoard(@RequestBody BoardRequestDto responseDto) {
        return boardService.postBoard(responseDto);
    }
    @GetMapping("/get/boards")
    public BoardListResponseDto getBoards() {
        return boardService.getBoards();
    }
    @GetMapping("/get/board")
    public BoardResponseDto getBoard(@RequestParam Long id) {
        return  boardService.getBoard(id);
    }
    //PathVariable /put/board/{id} 처럼 뒤에 {id} 를 쓸때 넣어줌.

    @PutMapping("/put/board/{id}")
    public BoardResponseDto putBoard(@PathVariable Long id, @RequestBody BoardRequestDto RequestDto) {
        return boardService.putBoard(id, RequestDto);
    }

    @DeleteMapping("/delete/board/{id}")
    public ResponseDto deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}
