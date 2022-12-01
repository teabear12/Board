package com.sparta.basic_crud_10.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardListResponseDto extends ResponseDto {
    static List<BoardResponseDto>boardList = new ArrayList<>();
    //기본 생성자
    public BoardListResponseDto() {
        super("게시글 목록 조회 성공", HttpStatus.OK.value());
    }

    public static void addBoard(BoardResponseDto responseDto) {
        boardList.add(responseDto);
    }
}
