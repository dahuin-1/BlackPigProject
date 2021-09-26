package com.huineey.blackpigproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

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

    @ManyToOne //게시글 입장에서는 매니 투 원
    @JoinColumn(name = "user_id", referencedColumnName = "id") //어떤 칼럼과 유저 테이블이 연결이 될지
    @JsonIgnore
    private User user;

    @ManyToOne //게시글 입장에서는 매니 투 원
    @JoinColumn(name = "store_id", referencedColumnName = "id") //어떤 칼럼과 유저 테이블이 연결이 될지
    @JsonIgnore
    private Store store;


}
