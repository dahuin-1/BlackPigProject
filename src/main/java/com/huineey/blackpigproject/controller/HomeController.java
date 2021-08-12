package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.StoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private StoreRepository storeRepository;

    public HomeController(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    @GetMapping
    public String index(Model model) {
        List<Store> storeList = storeRepository.findAll();
        model.addAttribute("stores", storeList);
        //디비에 식당 저장해두고 그걸 불러와서 에드어트리뮤트
        return "index";
    }
}
