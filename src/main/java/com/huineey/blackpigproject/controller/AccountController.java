package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Role;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.model.UserDTO;
import com.huineey.blackpigproject.repository.UserRepository;
import com.huineey.blackpigproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

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

    /*@PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/";
    }*/

    // 회원가입
    @PostMapping("/register")
    public String join(@RequestBody UserDTO user) {
        Long userId = userService.join(user);
        User newUser = userRepository.findById(userId).orElse(null);
        userRepository.save(newUser);
        /*return result != null ?
                ResponseEntity.ok().body("회원가입을 축하합니다!") :
                ResponseEntity.badRequest().build(); */
        return "redirect:/";
    }

}
