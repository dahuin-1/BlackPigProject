package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.repository.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private BoardRepository boardRepository;

    public HomeController(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @GetMapping
    public String index(Model model) {
        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("boards", boardList);
        //디비에 식당 저장해두고
        //그걸 불러와서
        //에드어트리뮤트

        return "index";
    }
}
