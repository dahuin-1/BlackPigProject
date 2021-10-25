package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.model.UserDTO;
import com.huineey.blackpigproject.repository.UserRepository;
import com.huineey.blackpigproject.service.UserService;
import com.huineey.blackpigproject.token.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/register")
    public String register() {
        return "account/register";
    }

    @GetMapping("/select")
    public String select() {
        return "account/select";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/";
    }

    // jwt토큰 발급 회원가입용 컨트롤러 + js 연결실패, 추후 연결 예정
    /*@PostMapping("/register")
    public String join(@RequestBody UserDTO user) {
        Long userId = userService.join(user);
        User newUser = userRepository.findById(userId).orElse(null);
        userRepository.save(newUser);
        return "redirect:/";
    }*/

}
