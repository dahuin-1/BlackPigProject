package com.huineey.blackpigproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id") //어떤 칼럼과 유저 테이블이 연결이 될지
    @JsonIgnore
    private Store store;

  /*  private String image1;
    private String image2;
    private String image3;
    private String image4;

    //thumbnail
    private String image5;
    private String image6;
    private String image7;
    private String image8;*/



}
