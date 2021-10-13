package com.huineey.blackpigproject.service;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Comment;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.CommentRepository;
import com.huineey.blackpigproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    /*public Comment save(Long id, String username, String text) {
        Board board = boardRepository.findOneById(id);
        User user = userRepository.findByUsername(username);
        Comment newComment = new Comment();
        newComment.setBoard(board);
        newComment.setText(text);
        newComment.setUser(user);
        return commentRepository.save(newComment);
    }*/
}