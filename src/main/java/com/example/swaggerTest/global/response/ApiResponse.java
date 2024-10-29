package com.example.swaggerTest.global.response;



public class ApiResponse<B> {
    private ApiResponseHeader header;
    private B body;                                  //ApiResponseBody
    //private static ApiResponse apiResponse = new ApiResponse();              //singleton pattern

    //default Constructor
    private ApiResponse () { }
    // Default 로 박아준다. 이전 단말 버전 호환 (단말에서 body 가 NULL일때 처리 못함)
    //body = new CommonResponseV2();

    //1) (public) method - Success
    public static <B> ApiResponse<B> of(ApiResponseHeader header, B body) {   //Refactoring
        ApiResponse<B> response = new ApiResponse<B>();                  //singleton pattern X
        response.setHeader(header);   //set header
        response.setBody(body);       //set body
        return response;
    }

    //2-1) (public) method - Exception
    public static ApiResponse of(ApiResponseHeader header) {
        ApiResponse response = new ApiResponse();        //singleton pattern X
        response.setHeader(header);   //set header
        return response;
    }

    //3) (public) getter, setter
    public ApiResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ApiResponseHeader header) {
        this.header = header;
    }

    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }

    //2-2) (public) method - Exception
    //public static ApiResponse of(ApiException apiException) {
    //    ApiResponse response = new ApiResponse();        //singleton pattern X
    //    response.setHeader(ApiResponseHeader.of(apiException.getResponseCode()));   //set header
    //    return response;
    //}

}