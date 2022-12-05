package com.sparta.basic_crud_10.entity;

import com.sparta.basic_crud_10.dto.BoardRequestDto;
import com.sparta.basic_crud_10.dto.BoardResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor //기본 생성자
public class Board {

    @Id
    //1. GeneratedValue 찾아보기 2. GenerationType.IDENTITY 와 GenerationType.auto 차이 알아보기!!
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String name;
    private String comments;
    private String password;

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.comments = requestDto.getComments();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto responseDto) {
        this.title = responseDto.getTitle();
        this.comments = responseDto.getComments();
        this.name = responseDto.getName();
        this.password = responseDto.getPassword();
    }
}
