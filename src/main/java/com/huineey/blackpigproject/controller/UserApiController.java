package com.huineey.blackpigproject.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.model.UserDTO;
import com.huineey.blackpigproject.repository.UserRepository;
import com.huineey.blackpigproject.service.UserService;
import com.huineey.blackpigproject.token.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
class UserApiController {

    @Autowired
    private UserRepository userRepository;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/users")
    List<User> all() {
        //return repository.findAll();
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }


    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                 /*   user.setTitle(newUser.getTitle());
                    user.setContent(newUser.getContent());*/
                    user.setBoards(newUser.getBoards());
                    for(Board board : user.getBoards()){
                        board.setUser(user);
                    }
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    //jwt 토큰 발급 방식의 회원가입 api
    @PostMapping("/join")
    public ResponseEntity join(@RequestBody UserDTO user) {
        Long result = userService.join(user);
        return result != null ?
                ResponseEntity.ok().body("회원가입을 축하합니다!") :
                ResponseEntity.badRequest().build();
    }

    // jwt 토큰 발급 방식의 로그인 api
   /* @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO user, HttpServletResponse response) {
        User member = userService.findUser(user);
        boolean checkResult = userService.checkPassword(member, user);
        if(!checkResult) {
            throw new IllegalArgumentException("아이디 혹은 비밀번호가 잘못되었습니다.");
        }
        String token = jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
        response.setHeader("authorization", "bearer " + token);
        return ResponseEntity.ok().body("로그인 성공!");
    }*/

    // jwt 토큰 발급 방식의 로그인 api
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO user, HttpServletResponse response) {
        User member = userService.findUser(user);
        boolean checkResult = userService.checkPassword(member, user);
        if(!checkResult) {
            throw new IllegalArgumentException("아이디 혹은 비밀번호가 잘못되었습니다.");
        }
        String token = jwtTokenProvider.createToken(member.getUsername());
        response.setHeader("authorization", "bearer " + token);
        return ResponseEntity.ok().body("로그인 성공!");
    }


    // 통합 예외 핸들러
    @ExceptionHandler
    public String exceptionHandler(Exception exception) {
        return exception.getMessage();
    }


}


