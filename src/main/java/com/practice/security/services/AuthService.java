package com.practice.security.services;

import com.practice.security.Repository.UserRepository;
import com.practice.security.dtos.UserRequestDto;
import com.practice.security.enums.Role;
import com.practice.security.models.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;

    AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(UserRequestDto request ){
        users user = new users();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
    }


}
