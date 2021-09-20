package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;
   /* @GetMapping("board/information")
    public String pig() {
        return "board/information";
    }*/

    @GetMapping("board/information")
    public String list(Model model,@RequestParam(required = false) Long id) {
        if(id == null){
            return  "board/information";
        }
        Store stores = storeRepository.findById(id).orElse(null);
        model.addAttribute("stores", stores);
        return "board/information"+id;
    }


}
