package com.huineey.blackpigproject.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String writer;

    @ManyToOne //게시글 입장에서는 매니 투 원
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;
}