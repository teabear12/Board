package com.sparta.basic_crud_10.entity;

import com.sparta.basic_crud_10.dto.BoardRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
//entity : 데이터베이스에 근접하는 영역
public class Board extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String name;
    private String password;
    private String contents;
    private String day;
    //생성자
    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }
    //수정되는 객체들
    public void update(BoardRequestDto responseDto) {
        this.title = responseDto.getTitle();
        this.contents = responseDto.getContents();
    }
}
