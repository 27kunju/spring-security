package com.practice.security.controllers;


import com.practice.security.dtos.UserRequestDto;
import com.practice.security.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final AuthService authService;

    UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserRequestDto request) {

        authService.register(request);
    }

}