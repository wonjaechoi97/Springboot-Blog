package com.won.blog.test;

import lombok.*;

@Data //getter+setter
//@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int id;
    private String username;
    private String password;
    private String email;

    @Builder //원하는 것만 추가해서
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
