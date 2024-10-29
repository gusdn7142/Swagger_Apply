package com.example.swaggerTest.global.exception;


import com.example.swaggerTest.global.response.ApiException;
import com.example.swaggerTest.global.response.ApiResponse;
import com.example.swaggerTest.global.response.ApiResponseHeader;
import com.example.swaggerTest.global.util.LoggingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.swaggerTest.global.response.ResponseCode.CUSTOM_ERROR_CLIENT_SIDE;
import static com.example.swaggerTest.global.response.ResponseCode.CUSTOM_ERROR_SERVER_SIDE;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //1) Request's Exception Hadnling
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException) {
        StringBuilder errorMessageStr = new StringBuilder();     //non-static

        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            if (errorMessageStr.length() > 0) {
                errorMessageStr.append(" , ");
            }
            errorMessageStr.append(error.getDefaultMessage());  //fieldName + " Field의 " +
            LoggingUtil.logData("error.getDefaultMessage()",error.getDefaultMessage());
        });

        CUSTOM_ERROR_CLIENT_SIDE.updateMessage(errorMessageStr.toString());
        return ApiResponse.of(ApiResponseHeader.of(CUSTOM_ERROR_CLIENT_SIDE));
    }

    //2) ApiException Handling
    @ExceptionHandler(value = ApiException.class)
    public ApiResponse handleApiException(ApiException apiException){
        log.error(">>> Occured GlobalExceptionHandler. handleException : " + apiException.getResponseCode().getMsg());

        return ApiResponse.of(ApiResponseHeader.of(apiException.getResponseCode()));
    }

    //3) ALL Exception Hadnling
    @ExceptionHandler(value = Exception.class)
    public ApiResponse handleException(Exception exception){
        log.error(">>> Occured GlobalExceptionHandler. handleException : " + exception.getMessage());
        exception.printStackTrace();

        //CUSTOM_ERROR.setCode("400");
        CUSTOM_ERROR_SERVER_SIDE.updateMessage(exception.getMessage());

        return ApiResponse.of(ApiResponseHeader.of(CUSTOM_ERROR_SERVER_SIDE));
    }




}
