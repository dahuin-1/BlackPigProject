package com.huineey.blackpigproject.service;


import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private StoreRepository storeRepository;

   // @Autowired
    //private UserRepository userRepository;

    public Board save(String username, Board board) {
       // User user = userRepository.findByUsername(username);
        //board.setUser(user);
       // storeID = storeRepository.
        return boardRepository.save(board);
    }

    public List<Board> getStoreReview(Long storeId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        storeId = store.getId();
        return boardRepository.findByStoreId(storeId);
    }


}