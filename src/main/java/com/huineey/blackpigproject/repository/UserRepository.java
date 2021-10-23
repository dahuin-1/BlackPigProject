package com.huineey.blackpigproject.repository;

import com.huineey.blackpigproject.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"boards"}) //n+1조인문제해결
    List<User> findAll();
    User findByUsername(String username);
}
// reset aad51cef075912fafd4eb3a17fe7bb067e5cc8d7