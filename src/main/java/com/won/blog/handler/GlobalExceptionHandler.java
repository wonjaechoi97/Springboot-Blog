package com.won.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 Exception 발생 시 여기로
@RestController
public class GlobalExceptionHandler {
    //Exception.class하면 모든 예외 여기로 모인다.
    @ExceptionHandler(value = IllegalArgumentException.class)//IllegalArgumentException이 발생하면 에러를 이 함수에 전달
    public String handleArgumentException(IllegalArgumentException e) {
        return "<h1>"+e.getMessage()+"</h1>";
    }


}
