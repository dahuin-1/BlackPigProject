package com.huineey.blackpigproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PigController {

    @GetMapping("pig/donjunam")
    public String pig() {
        return "pig/donjunam";
    }

}

