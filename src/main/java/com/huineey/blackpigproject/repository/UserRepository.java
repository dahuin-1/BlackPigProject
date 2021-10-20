package com.huineey.blackpigproject.repository;

import com.huineey.blackpigproject.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"boards"}) //n+1조인문제해결
    List<User> findAll();
    Optional<User> findByUsername(String username);
    User save(User account);
}