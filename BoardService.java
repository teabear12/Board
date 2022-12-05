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
@RequiredArgsConstructor
public class BoardService {

    //
    private final BoardRepository boardRepository;
    @Transactional
    public ResponseDto postBoard(BoardRequestDto responseDto) {
        //board 라는 entity 생성
        Board board = new Board(responseDto);

        //작성된 게시판 글의 정보 저장
        boardRepository.save(board);
        //BoardController 에서도 ResponseDto 로 반환한다.
        //200 출력
        return new ResponseDto("게시글 작성 완료", HttpStatus.OK.value());
    }

    @Transactional
    public BoardListResponseDto getBoards() {
        BoardListResponseDto boardListResponseDto = new BoardListResponseDto();

        List<Board> boards = boardRepository.findAll();
        for (Board board : boards) {
            boardListResponseDto.addBoard(new BoardResponseDto(board));
        }
        return boardListResponseDto;
    }

    @Transactional
    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("게시글을 조회할 수 없다.")
        );
        return new BoardResponseDto();
    }
    @Transactional
    public BoardResponseDto putBoard(Long id, BoardRequestDto requestDto) {
        //orElseThrow 예외처리하는 기능 한번더 보기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Board board = boardRepository.findById(id).orElseThrow(
                // 데이터 베이스에 id 가 존재하지 않는 경우 에러처리
                ()->new RuntimeException("게시글을 조회할 수 없다.")
        );
        //equals board 와 requestDto 를 비교하는 코드!!!!!!!!!!!!!!!!!!!!!!!!
        if (board.getPassword().equals(requestDto.getPassword())) {
            board.update(requestDto);
        }
        //클라이언트에서 가지고 온 데이터를 update 라는 메소드를 사용하여 교체하였습니다.
        //질문 업데이트는 save 가 필요없나요?
        return new BoardResponseDto(board);
    }

    public ResponseDto deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                ()->new RuntimeException("게시글을 조회할 수 없다.")
        );
        boardRepository.delete(board);
        return new ResponseDto("게시글 삭제 성공", HttpStatus.OK.value());
    }
}
