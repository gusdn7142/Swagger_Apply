package com.example.swaggerTest.global.response;

import com.example.swaggerTest.Entity.Product;

public enum ResponseCode {

    //2XX - Success
    SUCCESS("200", "응답 성공"),
    NULL_Product ("401", "해당 상품이 존재하지 않습니다."),

    CUSTOM_ERROR_CLIENT_SIDE("400", "잘못된 요청입니다."),  // 사용자 정의 에러는 일반적으로 400 Bad Request
    CUSTOM_ERROR_SERVER_SIDE("500", "서버에서 에러가 발생했습니다.");





    private String code;
    private String message;

    private ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.message;
    }

    public void updateCode(String code) {
        this.code = code;
    }

    public void updateMessage(String message) {
        this.message = message;
    }



}
