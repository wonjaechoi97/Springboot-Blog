package com.won.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//http://localhost:8000/blog/temp/home
@Controller //파일을 리턴하지
public class TempControllerTest {

    @GetMapping("/temp/home")
    public String tempHoem(){

        //파일 리턴 기본 경로 : src/main/resources/static
        return "home.html";
    }

    @GetMapping("/temp/img")                //static은 브라우저가 인식할 수 있는 정적인 파일 브라우저가 인식 못함
    public String tempImg(){
        return "/a.png";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        return "/test";
    }
}
