package com.won.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//인터넷 브라우저 요청은 get밖에 되지 않는다!
@RestController //data 응답 controller
public class HttpControllerTest {

    @GetMapping("/http/get")
    public String getTest(/*@RequestParam int id, @RequestParam String username*/ Member m){

        return "get 요청 :"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    @PostMapping("/http/post")
    public String postTest(){
        return "post 요청";
    }

    @PutMapping("/http/put")
    public String putTest(){
        return "put 요청";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}
