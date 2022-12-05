package com.sparta.basic_crud_10.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor//생성자
public class BoardRequestDto {
    private String title;
    private String comments;
    private String name;
    private String password;
}