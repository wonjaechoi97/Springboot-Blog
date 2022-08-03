package com.won.blog.handler;

import com.won.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 Exception 발생 시 여기로
@RestController
public class GlobalExceptionHandler {
    //Exception.class하면 모든 예외 여기로 모인다.
    @ExceptionHandler(value = Exception.class/*IllegalArgumentException.class*/)//IllegalArgumentException이 발생하면 에러를 이 함수에 전달
    public ResponseDto<String> handleArgumentException(Exception e) {

        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }




}
