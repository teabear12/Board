package com.sparta.basic_crud_10.controller;

import com.sparta.basic_crud_10.dto.BoardListResponseDto;
import com.sparta.basic_crud_10.dto.BoardRequestDto;
import com.sparta.basic_crud_10.dto.BoardResponseDto;
import com.sparta.basic_crud_10.dto.ResponseDto;
import com.sparta.basic_crud_10.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@RestController 를 달아주지 않으면 각 api 마다 response body 를 달아줘야된다.
@RestController
// "/api"를 묶어줌.
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {

    //이 부분을 응용해서 다른 부분 연습하기!!
    //@PostMapping("/write/board")부분 Controller 와 service 간의 상호작용을 다른 부분도 연습하기!!!
    //BoardService 필드 선언
    private final BoardService boardService;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //게시글 작성 api / 해야되는 부분 : 아이디 대신 비밀번호 넣기
    @PostMapping("/write/board")
    //데이터를 클라이언트에서 받아왔음.
    public ResponseDto writeBoard(@RequestBody BoardRequestDto requestDto) {
        //api 주소 입력했을 때,
        System.out.println("requestDto.getContents() = " + requestDto.getContents());
        //클라이언트에서 받은 requestDto 를 boardService 에도 전달해줄게
        //서비스에서 return 한 부분을 Controller 에서 받아주는 부분
        ResponseDto responseDto = boardService.writeboard(requestDto);
        //클라이언트에게 응답을 전달하는 부분
        return responseDto;
        //위 두줄과 같음.
              //return boardService.writeboard(requestDto);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //전체 게시글 목록 조회 api
    @GetMapping("/get/boards")
    public BoardListResponseDto getBoards() {
        return boardService.getBoards();
    }
    //선택한 게시글 조회 api
    @GetMapping("/get/board")
    public BoardResponseDto getBoard(@RequestParam Long id) {
        return boardService.getBoard(id);
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