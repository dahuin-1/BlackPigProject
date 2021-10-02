package com.huineey.blackpigproject.service;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private StoreRepository storeRepository;

    public Store save(String name, Store store) {
        Long id = storeRepository.findByName(name);
        store.setId(id);
        return storeRepository.save(store);
    }

    public List<Store> getStoreName(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        Long storeId = board.getStore().getId();
        return storeRepository.findOneById(storeId);
    }

}
