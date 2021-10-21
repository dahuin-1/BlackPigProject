package com.huineey.blackpigproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // username
    @Column(nullable = false, unique = true)
    private String username;

    // Password
    @Column(nullable = false)
    private String password;

    private Boolean enabled;

   /* @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    // Roles
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roleList = new ArrayList<>();*/

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();



    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();

}
