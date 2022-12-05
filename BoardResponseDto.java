package com.sparta.basic_crud_10.dto;

import com.sparta.basic_crud_10.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private String title;
    private String comments;
    private String name;

    public BoardResponseDto(Board board) {
        this.title = board.getTitle();
        this.comments = board.getComments();
        this.name = board.getName();
    }
}
