package com.huineey.blackpigproject.service;


import com.huineey.blackpigproject.model.Role;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.model.UserDTO;
import com.huineey.blackpigproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());//암호화
        user.setPassword(encodedPassword); //저장
        user.setEnabled(true);
        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    public Long join(UserDTO user) {
        Role role = new Role();
        role.setId(1l);
        Long userId = userRepository.save(
                User.builder()
                        .username(user.getUsername())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .enabled(true)
                        //.role(Collections.singletonList("ROLE_USER"))
                        .roles((Collections.singletonList(role)))
                        .build())
                .getId();
        return userId;
    }


    public User findUser(UserDTO user) {
        User member = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호가 잘못되었습니다."));
        return member;
    }

    public boolean checkPassword(User member, UserDTO user) {
        return passwordEncoder.matches(user.getPassword(), member.getPassword());
    }


}
