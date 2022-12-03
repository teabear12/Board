package com.sparta.basic_crud_10.dto;

import com.sparta.basic_crud_10.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//제일 기본인 생성자 어노테이션이다. 아무 인수가 없는 생성자를 셍성해준다.
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
