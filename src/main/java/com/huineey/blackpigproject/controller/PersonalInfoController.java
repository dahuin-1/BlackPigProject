package com.huineey.blackpigproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal")
public class PersonalInfoController {

    @GetMapping("/info")
    public String info() {
        return "personal/info";
    }
}
