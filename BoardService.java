package com.sparta.basic_crud_10.service;

import com.sparta.basic_crud_10.dto.BoardListResponseDto;
import com.sparta.basic_crud_10.dto.BoardRequestDto;
import com.sparta.basic_crud_10.dto.BoardResponseDto;
import com.sparta.basic_crud_10.dto.ResponseDto;
import com.sparta.basic_crud_10.entity.Board;
import com.sparta.basic_crud_10.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor 가 무엇일까?
@RequiredArgsConstructor
public class BoardService {
    //데이터 베이스와 소통하는 repository 연결
    private final BoardRepository boardRepository;



    //컨트롤러로부터 requestDto 를 받아주는 부분
    //서비스가 하는 역할
    @Transactional
    public ResponseDto writeboard(BoardRequestDto requestDto) {
        //1. requestDto 값들을 Board 라는 entity 에 넣어준다.
        Board board = new Board(requestDto);
        //2. Board 라는 entity 를 이용해서 데이터베이스에 값을 저장한다.
        boardRepository.save(board);
        //BoardController 에서도 ResponseDto 로 반환하기 때문에 ResponseDto 로 반환
        //컨트롤러에게 응답값을 내려주는 부분 return 이 컨트롤러한테 다시 반환한다.
        return new ResponseDto("글쓰기 완료", HttpStatus.OK.value());
    }

    @Transactional
    public BoardListResponseDto getBoards() {
        //BoardListResponseDto 에 BoardListResponseDto 생성자가 있고 그 생성자의 객체가 바로 밑에 코드이다.
        BoardListResponseDto boardListResponseDto = new BoardListResponseDto();

        //ArrayList 를 이용하여 작성할 수도 있음.
        List<Board> boards = boardRepository.findAll();
        for (Board board : boards) {
            BoardListResponseDto.addBoard(new BoardResponseDto(board));
        }
        return boardListResponseDto;
    }

    @Transactional
    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("게시글을 찾을 수 없다")
        );
        return new BoardResponseDto(board);
    }
    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("강의를 찾을 수 없다")
        );
        board.update(requestDto);

        return new BoardResponseDto(board);
    }
    @Transactional
    public ResponseDto deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("강의를 찾을 수 없다")
        );
        boardRepository.delete(board);
        return new ResponseDto("게시글 삭제 성공", HttpStatus.OK.value());
    }
}
