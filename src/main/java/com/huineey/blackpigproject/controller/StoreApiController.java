package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class StoreApiController {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/stores/{id}")
    Store one(@RequestParam(required = false, defaultValue = "") Long id) {
        return storeRepository.findById(id).orElse(null);
    }


   /* @GetMapping("/boards")
   sds
    List<Board> all(@RequestParam(required = false, defaultValue = "") String title,
                    @RequestParam(required = false, defaultValue = "") String content) {
        if(StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
            return repository.findAll();
        }
        return repository.findByTitleOrContent(title, content);
    }*/



}
