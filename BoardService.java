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
    private static final BoardRepository boardRepository = null;



    @Transactional
    public ResponseDto writeboard(BoardRequestDto requestDto) {
        //데이터의 한 row 를 만들었다.
        Board board = new Board(requestDto);
        boardRepository.save(board);
        //BoardController 에서도 ResponseDto 로 반환하기 때문에 ResponseDto 로 반환
        return new ResponseDto("글쓰기 완료", HttpStatus.OK.value());
    }

    @Transactional
    public BoardListResponseDto getBoards() {
        BoardListResponseDto boardListResponseDto = new BoardListResponseDto();

        List<Board> boards = boardRepository.findAll();
        for (Board board : boards) {
            BoardListResponseDto.addBoard(new BoardResponseDto(board));
        }
        return boardListResponseDto;
    }

    @Transactional
    public static BoardResponseDto getBoard(Long id) {
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
