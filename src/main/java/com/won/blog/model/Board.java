package com.won.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //orm database 명시
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob//대용량 데이터
    private String content; //길이가 길 수 있고, 섬머 노트 라이브러리 사용 예정 <html> 태그가 섞여서 디자인 됨., 용량이 큼!!!

    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne(fetch = FetchType.EAGER) //연관 관계 Board가 many, user가 one 즉, 한명의 유저는 여러 개의 글을 쓸 수 가 있다.
    @JoinColumn(name = "userId") //table 만들어질 때 이름
    private User user; //원래 foreign key로 한다.
    /*
    DB에는 object를 저장할 수 없다. Fk 사용, 자바는 오브젝터 저장 가능,
    fetch = FetchType.EAGER = board를 select하면 user 정보는 한 건 밖에 없으니 가져올게 default
     */

    @OneToMany(mappedBy ="board", fetch=FetchType.EAGER)  //게시글 하나에 여러 reply 다만 foreign key는 아니므로 JoinColumn은 필요 없다.
    private List<Reply> reply; //보드를 불러오면 댓글도 필요하므로 Board + User + Reply
    /*board 하나에 reply가 하나면 안되므로 reply는 List 가 되어야 한다.
    mapped by가 나오면 연관관계의 주인이 아니다. (fk가 아니다. ) db에 컬럼 만들지 마라, mappedBy ="reply의 필드 적기"
    reply의 board id가 foreign key
    단순히 board select 시 join 해서 얻기 위해 필요한 것이다.
    fetch=FetchType.LAZY = 필요하면 가져올게 왜냐 엄청나게 많을 수 있으니깐 default 펼치기 버튼 있는 경우 LAZY 그냥 나열할 때는 EAGER
*/


    @CreationTimestamp
    private Timestamp createDate;
}
