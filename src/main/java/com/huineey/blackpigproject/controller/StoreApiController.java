package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class StoreApiController {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/stores/{id}")
    Store one(@PathVariable Long id) {
        return storeRepository.findById(id).orElse(null);
    }


}
