package com.sparta.basic_crud_10.dto;

import lombok.Getter;

//Serialize, Deserialize 관련 구글링 해보기
@Getter
//api table 의 {msg : "작성 완료", statusCode : int} 부분 변수 지정
public class ResponseDto {
    private String msg;
    private int statusCode;

    public ResponseDto(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }

}
