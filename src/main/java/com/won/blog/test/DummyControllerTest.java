package com.won.blog.test;

import com.won.blog.model.RoleType;
import com.won.blog.model.User;
import com.won.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입
    private UserRepository userRepository;

    //{id}주소로 파라미터를 전달 받을 수 있음음
   @GetMapping("dummy/user/{id}")
    public User detail(@PathVariable int id){
       // user의 4를 찾으면 데이터베이스에서 못 찾아오게 되면 user가 null이 되고 리턴 시 null이 되고 프로그램에 문제가 있기 때문에
       // 그래서 Optional로 User객체를 감싸서 가져올테니 null인지 아닌지 판단해서 리턴
        /*User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
            @Override //인터페이스를 new 하기 위해거는 new 하면서 바로 override
            public User get() {
                return new User(); //빈 객체는 적어도 null은 아니다.
            }
        });//orElseGet:없으면 네가 하나 넣어줘//.get()==절대 없으니 그냥 User 객체 리턴 ;*/
       User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() { //없으면 잘못된 인자 예외 던지기
           @Override
           public IllegalArgumentException get() {
               return new IllegalArgumentException("해당 유저는 없습니다. id: "+id);
           }
       });
       /*요청 : 웹 브라우저
       * user 객체 이해 못함
       * 변환 필요 웹 브라우저가 이해할 수 있는 데이터 예) json
       * spring boot는 message convertor가 응답 시에 자동으로 변환환
       * 만약 자바 오브젝트 리턴시 MessageConvertor가 Jackson라이브러리 호출해서 user 오브젝트를 json으로 변환해서 브라우저에게 건냄*/
       return user;
    }

    //전체 다 받기
    @GetMapping("/dummy/users")
    public List<User> list(){
       return userRepository.findAll();
    }

    //한 페이지 당 2건
   /* @GetMapping("dummy/user")
    public Page<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC)Pageable pageable){
       Page<User> users= userRepository.findAll(pageable);
       return users;
    }*/
    @GetMapping("dummy/user")
    public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC)Pageable pageable) {
        Page<User> paginUser = userRepository.findAll(pageable);

        if(paginUser.isLast()){
            //분기 처리 가능
        }
        List<User> users = paginUser.getContent();
        return users;
    }
    @PostMapping("/dummy/join")
    public String join(User user){ //요청시 body에  username password email이 있으면 자동으로 들어옴
        //변수명을 적기만 하면 key = value (약속된 규칙)만 받을 수 있다. xx
        //또한 User 객체로 받을 수도 있다.
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());


        user.setRole(RoleType.USER); //개발자들이 user2 이렇게 잘 못 넣을 수 있음 그래서 enum사용

        userRepository.save(user);//insert role빼고 잘 들어감 ..
        //spring에서 @CreateTimestamp 붙이면 현재 시간 넣고 insert ==> 잘 들어감


        return "회원가입 완료";
    }
}
