package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class BoardApiController {

    @Autowired
    private BoardRepository repository;

    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }


}
