package com.huineey.blackpigproject.service;


import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

   // @Autowired
    //private UserRepository userRepository;

    public Board save(String username, Board board) {
       // User user = userRepository.findByUsername(username);
        //board.setUser(user);
        return boardRepository.save(board);
    }

}