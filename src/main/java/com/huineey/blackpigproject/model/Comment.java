package com.huineey.blackpigproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    /*@ManyToOne //게시글 입장에서는 매니 투 원
    @JoinColumn(name = "writer", referencedColumnName = "id") //어떤 칼럼과 유저 테이블이 연결이 될지
    @JsonIgnore*/
    private String writer;

    @ManyToOne //게시글 입장에서는 매니 투 원
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;
}