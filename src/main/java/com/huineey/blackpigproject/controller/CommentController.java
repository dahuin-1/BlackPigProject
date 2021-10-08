package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Comment;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    List<Comment> all(@RequestParam(required = false, defaultValue = "") String content) {
        if (StringUtils.isEmpty(content)) {
            return commentRepository.findAll();
        }
        return commentRepository.findCommentByContent(content);
    }

    @PostMapping("/comments/{id}")
    Comment CreateComment(@RequestParam String comment, @PathVariable Long id) {
        //validation
        Board board = boardRepository.findOneById(id);
        String username = "댓쓴이";
                //= authentication.getName();
        Comment newComment = new Comment();
        newComment.setBoard(board);
        newComment.setContent(comment);
        newComment.setWriter(username);
        return commentRepository.save(newComment);
    }

    @DeleteMapping("/comments/{id}")
    void deleteBoard(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}
