package com.won.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에 연결된 db의 연결 전략을 따를 것
    private int id; //시퀀스 오토 인크

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne // 여러개의 댓글(many) 하나(one)의 보드 있을 수 있다.
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne //하나의 유저는 여러개의 답변을 달 수 있다.
    @JoinColumn(name="userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;


}
