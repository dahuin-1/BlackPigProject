package com.huineey.blackpigproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Long year;
    private String thumbnail;

  /*  @OneToMany
    @JsonIgnore
    private List<Picture> pictures;*/


   /* @OneToMany(mappedBy = "store")
    //스토어 입장에서 리뷰를 가져올 때
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();*/

}
