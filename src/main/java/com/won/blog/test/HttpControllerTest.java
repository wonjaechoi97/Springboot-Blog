package com.won.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//인터넷 브라우저 요청은 get밖에 되지 않는다!
@RestController //data 응답 controller
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest";

    @GetMapping("http/lombok")
    public String lombokTest(){
        Member m = new Member().builder().id(1)
                .username("wj5295")
                .password("1234")
                .email("wj5295@naver.com").build();
        System.out.println(TAG+"getter : "+m.getId());
        m.setId(5000);
        System.out.println(TAG+"setter : "+m.getId());
        return "get 요청 :"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    @GetMapping("/http/get")
    public String getTest(/*@RequestParam int id, @RequestParam String username*/ Member m){

        return "get 요청 :"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m){ //json으로 보내면 message convertor가 자동으로 매핑
        return "post 요청 :"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
//            return "test";
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
