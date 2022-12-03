package com.sparta.basic_crud_10.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//프론트에서 받아옴.
public class BoardRequestDto {
    private String title;
    private String name;
    private String password;
    private String contents;
    private String day;
}
