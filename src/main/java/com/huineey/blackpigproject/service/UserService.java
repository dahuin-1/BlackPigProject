package com.huineey.blackpigproject.service;


import com.huineey.blackpigproject.dto.UserDTO;
import com.huineey.blackpigproject.model.Role;
import com.huineey.blackpigproject.model.User;
import com.huineey.blackpigproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
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
        Long id = userRepository.save(
                User.builder()
                        .username(user.getUsername())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .roletype(Collections.singletonList("ROLE_USER"))
                        .build())
                .getId();
        return id;
    }
}


