package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.repository.StoreRepository;
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

  //  @Autowired
  //  private Store store;


    @GetMapping("board/information")
    public String info(Model model) {
        Long id = new Long(1);
      //  String name = store.getName();
       // Long id = storeRepository.findByName(name);
        Store stores = storeRepository.findById(id).orElse(null);
        model.addAttribute("stores", stores);
        return "board/information";
    }

    @GetMapping("board/information/{id}")
    public String info(Model model, @PathVariable Long id) {
        Store stores = storeRepository.findById(id).orElse(null);
        model.addAttribute("stores", stores);
        return "board/information";
    }
}
