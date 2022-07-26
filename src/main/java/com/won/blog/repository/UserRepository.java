package com.won.blog.repository;

import com.won.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//DAO
//자동으로 빈으로 등록도미.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer > { //User테이블을 관리하고 이 테이블의 키는 정수다

}
