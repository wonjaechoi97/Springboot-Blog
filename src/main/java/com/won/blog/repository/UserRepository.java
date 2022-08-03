package com.won.blog.repository;

import com.won.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//DAO
//자동으로 빈으로 등록도미.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer > { //User테이블을 관리하고 이 테이블의 키는 정수다
    //JPA Naming 쿼리 : 실제로 이런 함수는 없지만
    //이게 자동으로 실행 : SELECT * FROM user  WHERE username=? AND password=?
    User findByUsernameAndPassword(String username, String password);

    /*위에 껄 더 자주 사용 이렇게 간단한 경우
    @Query(value = "SELECT * FROM user  WHERE username=? AND password=?", nativeQuery = true)
    User login(String username, String password);*/
}
