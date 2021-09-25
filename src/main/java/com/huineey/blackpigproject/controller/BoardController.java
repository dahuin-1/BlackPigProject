package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.BoardRepository;
import com.huineey.blackpigproject.service.BoardService;
import com.huineey.blackpigproject.validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String list(Model model, @PageableDefault(size = 2) Pageable pageable,
                       @RequestParam(required = false, defaultValue = "") String searchText) {
       // List<Board> boards = boardRepository.findAll();
        Page<Board> boards = boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        //(required = false) 필수인지 아닌지, 새글을 작성할때는 파라미터가 필요 없다
        if(id == null){
            model.addAttribute("board", new Board());
            //아이디가 null이면 새 보드 클래스를 생성해서 form에 넘김
        } else {
            Board board = boardRepository.findById(id).orElse(null);
           // List<Comment> comments = commentRepository.findCommentsByBoard(board);
            //boardRepository 에서 아이디로 값을 찾아서 넘긴다. 아이디가 없으면 null을 넘긴다.

            model.addAttribute("board", board);
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
                //authentication.getName();
        boardService.save(username, board);
        return "redirect:/board/list"; //리스트로 리다이렉트가 되면, 리스트에서 다시 한번 조회가 되면서 화면이 이동
    }


}