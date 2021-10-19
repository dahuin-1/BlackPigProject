package com.huineey.blackpigproject.controller;

import com.huineey.blackpigproject.model.Role;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
            //return userRepository.save(user);

        // 연결

        URL url = new URL("https://localhost:8081/login");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);

        conn.setRequestMethod("POST"); // 보내는 타입

        conn.setRequestProperty("Accept-Language", "ko-kr,ko;q=0.8,en-us;q=0.5,en;q=0.3");

        // 데이터

        String param ="{\"role\": \"user\", \"username\": user.username , \"password\": \"user.password\"}";


        // 전송

        OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
        try {
            osw.write(param);
            osw.flush();

            // 응답
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


            // 닫기
            osw.close();
            br.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}
