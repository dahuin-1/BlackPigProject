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

    @Autowired //디펜던시 인젝션을 이용하기 위해서! 서버기동될때 인스턴스가 넘어간다.
    private StoreRepository storeRepository; //보드 레파지토리를 이용해서 값을 넘긴다.

   /* @GetMapping("board/information")
    public String pig() {
        return "board/information";
    }*/

    @GetMapping("board/information")
    public String list(Model model,@RequestParam(required = false) Long id) {
        //데이터값을 추가하고 싶을 때 파라미터로 모델 넘김
        //   Page<Board> boards = boardRepository.findAll(pageable);
        if(id == null){
            return  "board/information";
        }
        Store stores = storeRepository.findById(id).orElse(null);
        model.addAttribute("stores", stores); //키값에 boards를 줍니다.
        return "board/information";
    }

}
