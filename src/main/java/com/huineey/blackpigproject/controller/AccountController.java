package com.huineey.blackpigproject.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.model.UserDTO;
import com.huineey.blackpigproject.repository.UserRepository;
import com.huineey.blackpigproject.service.UserService;
import com.huineey.blackpigproject.token.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

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

    // jwt토큰 발급 회원가입용 컨트롤러 + String -> json
    /*@PostMapping("/register")
    public String join(@RequestBody UserDTO user) {
        Long userId = userService.join(user);
        User newUser = userRepository.findById(userId).orElse(null);
        userRepository.save(newUser);
        return "redirect:/";
    }*/

}
