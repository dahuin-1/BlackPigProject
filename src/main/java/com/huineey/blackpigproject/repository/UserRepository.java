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

// 리셋하고 싶은 커밋 id AAAA , master 브랜치 , nbranch
// master 에서 git checkout -b <임시저장할 브랜치 이름>
// AAAA 내용으로 master를 리셋하기  git reset --hard AAAA
// 리셋한 master에서 아무 내용이나 추가해서 커밋하기
// git push -f origin master로 푸시하기
