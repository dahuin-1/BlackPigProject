package com.huineey.blackpigproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private String rating;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    //@JsonIgnore
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    //@JsonIgnore
    private User user;



}
