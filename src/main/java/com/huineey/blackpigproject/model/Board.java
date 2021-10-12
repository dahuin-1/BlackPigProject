package com.huineey.blackpigproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=2, max=30, message = "제목은 2자이상 30자 이하입니다")
    private String title;
    private String content;

    private String rating;

    @Formula("(select count(user) from Likes l where l.post_id = id)")
    private int countLike;

    public boolean isLiked(){
        return getCountLike() > 0;
    }

  /*  @NotNull
    @Size(min=1, max=1, message = "스토어 아이디는 숫자로만 입력해주세요")
    private Long store_id;*/

    @ManyToOne //게시글 입장에서는 매니 투 원
    @JoinColumn(name = "user_id", referencedColumnName = "id") //어떤 칼럼과 유저 테이블이 연결이 될지
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id") //어떤 칼럼과 스토어 테이블이 연결이 될지
    @JsonIgnore
    private Store store;


}
