package com.huineey.blackpigproject.repository;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByBoard(Board post);
    List<Comment> findCommentByText(String text);
}



