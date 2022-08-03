package com.won.blog.controller.api;

import com.won.blog.dto.ResponseDto;
import com.won.blog.model.RoleType;
import com.won.blog.model.User;
import com.won.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {
    //bean으로 받기 가능
  /*  @Autowired
    HttpSession session;*/

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출됨");
        //실제 Db에 insert를 하고 아래에서 리턴이 되면 됨
        user.setRole(RoleType.USER);
//        int result = userService.join(user);
        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바 오브젝트를 JSON으로 변환해서 리턴
    }

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
        System.out.println("UserApiController : login 호출됨");
        User principal = userService.login(user);//principal(접근 주체)
        if(principal!=null){
            session.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바 오브젝트를 JSON으로 변환해서 리턴

    }
}
