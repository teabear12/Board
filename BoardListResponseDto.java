package com.sparta.basic_crud_10.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardListResponseDto extends ResponseDto{

    List<BoardResponseDto> boardList = new ArrayList<>();

    public BoardListResponseDto() {
        super("전체 게시글 목록 조회", HttpStatus.OK.value());
    }
    //BoardList 에 넣어주는 코드
    public void addBoard(BoardResponseDto ResponseDto) {
        boardList.add(ResponseDto);
    }
}
