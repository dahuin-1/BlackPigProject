package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.service.BoardService;
import com.huineey.blackpigproject.validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardValidator boardValidator;

    @GetMapping("list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    /*
      @GetMapping("board/list")
       public String list(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam(required = false, defaultValue = "")String searchText) {
        Page<Board> boards = boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        model.addAttribute("boards", boards);
        return "board/list";
    }
     */

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        if(id == null){
             model.addAttribute("board", new Board());
        } else {
            Board board = boardRepository.findById(id).orElse(null);
            // List<Comment> comments = commentRepository.findCommentsByBoard(board);
            //boardRepository 에서 아이디로 값을 찾아서 넘긴다. 아이디가 없으면 null을 넘긴다.
            model.addAttribute("boards", board);
            //model.addAttribute("comments",comments);
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String postForm(@Valid Board board, BindingResult bindingResult) {
        boardValidator.validate(board, bindingResult);
        if(bindingResult.hasErrors()){
            return "board/form";
        }
        //Authentication a = SecurityContextHolder.getContext().getAuthentication(); 컨트롤러가 아닌 서비스 클래스에선 이렇게
        String username = "주인장";
        boardService.save(username, board);
        boardRepository.save(board);
        return "redirect:/board/list"; //리스트로 리다이렉트가 되면, 리스트에서 다시 한번 조회가 되면서 화면이 이동
    }

}