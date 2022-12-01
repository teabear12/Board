package com.sparta.basic_crud_10.controller;

import com.sparta.basic_crud_10.dto.BoardListResponseDto;
import com.sparta.basic_crud_10.dto.BoardRequestDto;
import com.sparta.basic_crud_10.dto.BoardResponseDto;
import com.sparta.basic_crud_10.dto.ResponseDto;
import com.sparta.basic_crud_10.repository.BoardRepository;
import com.sparta.basic_crud_10.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@RestController 를 달아주지 않으면 각 api 마다 response body 를 달아줘야된다.
@RestController
// "/api"를 묶어줌.
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;
    //게시글 작성 api / 해야되는 부분 : 아이디 대신 비밀번호 넣기
    @PostMapping("/write/board")
    //데이터를 클라이언트에서 받아왔음.
    public ResponseDto writeBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.writeboard(requestDto);
    }
    //전체 게시글 목록 조회 api
    @GetMapping("/get/boards")
    public BoardListResponseDto getBoards() {
        return boardService.getBoards();
    }
    //선택한 게시글 조회 api
    @GetMapping("/get/board")
    public BoardResponseDto getBoard(@RequestParam Long id) {
        return BoardService.getBoard(id);
    }
    //선택한 게시글 수정 api / 수정 요청시 서버 비밀번호와 작성자 비밀번호 일치 확인
    @PutMapping("/update/board/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }
    //선택한 게시글 삭제 api / 수정 요청시 서버 비밀번호와 작성자 비밀번호 일치 확인
    @DeleteMapping("/delete/board/{id}")
    public ResponseDto deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}
