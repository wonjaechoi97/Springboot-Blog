package com.won.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
모든 기본 패키지는 com.won.blog com.won.test 이렇게 만들면 스캔을 못해서 빈 객체로 관리를 못함
 */

@RestController   // 컨테이너에서 관리됨
public class BlogTestController {

    @GetMapping("/test/hello")
    public String hello(){
        return "<h1>hello spring boot</h1>";
    }

}
