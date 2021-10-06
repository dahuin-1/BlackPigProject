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

    private String large1;
    private String large2;
    private String large3;
    private String large4;

    //thumbnail
    private String thumb1;
    private String thumb2;
    private String thumb3;
    private String thumb4;


}
