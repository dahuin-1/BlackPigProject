package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Role;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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



    /*@GetMapping("/login")
    public void login(User user) throws IOException {
            String encodedPassword = passwordEncoder.encode(user.getPassword());//암호화
            user.setPassword(encodedPassword); //저장
            user.setEnabled(true);
            Role role = new Role();
            role.setId(1l);
            user.getRoles().add(role);
            //return userRepository.save(user);*/



}
