//추상클래스 같은 클래스(부모 클래스로 공통된 코드 클래스)
package com.sparta.basic_crud_10.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {
    private String msg;
    private int statusCode;

    public ResponseDto(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
