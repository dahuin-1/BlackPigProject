package com.huineey.blackpigproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index() {

        //디비에 식당 저장해두고
        //그걸 불러와서
        //에드어트리뮤트

        return "index";
    }
}
