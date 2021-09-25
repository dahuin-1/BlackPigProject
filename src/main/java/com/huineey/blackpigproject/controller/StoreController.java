package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.StoreRepository;
import com.huineey.blackpigproject.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreService storeService;
    private Store id;


    @GetMapping("board/information")
    public String info(Model model) {
        List<Store> stores = storeRepository.findAll();
        model.addAttribute("stores", stores);
        for (int i = 0; i < stores.size(); i++) {
            System.out.println(stores.get(i).getId());
        }
        return "board/information";
    }

    @GetMapping("board/detail")
    public String one(Model model, @RequestParam(required = false, defaultValue = "") Long id) {
        if(id == null){
            System.out.println("아이디가 없습니다");
            return "redirect:/board/information";
        }else {
            Store store = storeRepository.findById(id).orElse(null);
            model.addAttribute("store", store);
            return "board/detail";
        }
    }

  /*  @GetMapping("board/information/{id}")
    public String info(Model model, @PathVariable Long id) {
        Store store = storeRepository.findById(id).orElse(null);
        model.addAttribute("store", store);
        //return "board/detail";
        return "board/information";
    }*/
}
