package com.won.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

//ORM =-->JAVA(다른 언어 포함) Object -> 테이블로 매핑하는 기술
@Entity //테이블화  User 클래스를 읽어서 자동으로 mysql에 테이블 생성됨
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert//insert 시 null인 부분은 제외
public class User {
    /*
        autoincrement, CreationTimestamp  --> 비여도 됨
     */

    @Id //pk
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //프로젝트에서 연결된 db의 넘버링 전략을 따라간다. mysql:auto incre
    private int id;//auto increment                      //yml 파일의 jpa use-new-id-generator-mappings: false
                                                        //jpa의 기본 넘버링 전략 사용 안함
    @Column(nullable = false, length = 30)
    private String username; //아이디

    @Column(nullable = false, length = 100) // 암호화해서 넣을 것이기 때문에 넉넉히 100
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

//    @ColumnDefault("'user'") null값 안들어가게 해야됨
    @Enumerated(EnumType.STRING)//db에는 enum이 없기에 해당 타입이 String이라는 것을 명시
    private RoleType role; // Enum을 쓰는 것이 좋다 admin, user, manager가 있는데 만약 managerrrrr를 악의 적으로 넣는 다면? 성별이 남, 여 인 것
    //처럼 도메인 설정을 할 수 있지만 여기선 그냥 string, Enum 사용해서 타입 강제

    @CreationTimestamp //시간 자동으로 입력
    private Timestamp createDate;

}
