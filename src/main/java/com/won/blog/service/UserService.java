package com.won.blog.service;

import com.won.blog.model.User;
import com.won.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service //ioc
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional //전체가 성공하면 커밋 하나라도 실패하면 rollback
    public Integer join(User user) {
        try{
            userRepository.save(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("UserService: 회원가입 join(): "+e.getMessage());
        }
            return -1;
    }

    @Transactional(readOnly = true)//select할 때 트랜잭션 시작, 종료시 트랜잭션 종료(정합성 유지)
    public User login(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }


}

