package com.huineey.blackpigproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PigController {

    @GetMapping("board/information")
    public String pig() {
        return "board/information";
    }

}

