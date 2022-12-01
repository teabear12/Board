package com.sparta.basic_crud_10.dto;

import com.sparta.basic_crud_10.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private String title;
    private String name;
    private String contents;
    private String day;
    private String password;

    public BoardResponseDto(Board board) {
        this.title = getTitle();
        this.name = getName();
        this.password = getPassword();
        this.contents = getContents();
        this.day = getDay();
    }
}
