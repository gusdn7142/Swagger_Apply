package com.example.swaggerTest.global.response;



public class ApiException extends RuntimeException {

    private ResponseCode responseCode;

    //constructor
    public ApiException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    //getter
    public ResponseCode getResponseCode() {
        return responseCode;
    }
}