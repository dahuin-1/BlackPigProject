package com.huineey.blackpigproject.service;


import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Comment;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.CommentRepository;
import com.huineey.blackpigproject.repository.StoreRepository;
import com.huineey.blackpigproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Board save(String username, Board board) {
        User user = userRepository.findByUsername(username).orElse(null);
        board.setUser(user);
        return boardRepository.save(board);
    }

    public List<Board> getStoreReview(Long storeId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        storeId = store.getId();
        return boardRepository.findByStoreId(storeId);
    }

    public Board getBoardByComment(Long commentId){
        Board board = commentRepository.findById(commentId).orElseThrow().getBoard();
        return boardRepository.findOneById(board.getId());
    }
}