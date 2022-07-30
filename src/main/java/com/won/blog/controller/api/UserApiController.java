package com.won.blog.controller.api;

import com.won.blog.dto.ResponseDto;
import com.won.blog.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출됨");
        //실제 Db에 insert를 하고 아래에서 리턴이 되면 됨
        return new ResponseDto<Integer>(HttpStatus.OK, 1); //자바 오브젝트를 JSON으로 변환해서 리턴
    }
}
