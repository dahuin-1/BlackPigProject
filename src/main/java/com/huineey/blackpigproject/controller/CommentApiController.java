package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Comment;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.CommentRepository;
import com.huineey.blackpigproject.repository.UserRepository;
import com.huineey.blackpigproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentApiController {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> all(@RequestParam(required = false, defaultValue = "") String text) {
        if (StringUtils.isEmpty(text)) {
            return commentRepository.findAll();
        }
        return commentRepository.findCommentByText(text);
    }

    @PostMapping("/comments/{id}")
    Comment CreateComment(@RequestParam String comment, @PathVariable Long id, Authentication authentication) {
        //validation
        Board board = boardRepository.findOneById(id);
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(null);
        Comment newComment = new Comment();
        newComment.setBoard(board);
        newComment.setText(comment);
        newComment.setUser(user);
        newComment.setDatetime(LocalDateTime.now());
        //newComment.setDatetime(currentTime);
        return commentRepository.save(newComment);
    }

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable Long id,Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(null);
        commentRepository.findCommentByUser(user);
        commentRepository.deleteById(id);
    }

    @PutMapping("/comments/{id}")
    Comment replaceComment(@RequestBody Comment newComment, @PathVariable Long id) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setText(newComment.getText());
                  //  comment.setDatetime(newComment.getDatetime());
                    return commentRepository.save(comment);
                })
                .orElseGet(() -> {
                    newComment.setId(id);
                    return commentRepository.save(newComment);
                });
    }
}