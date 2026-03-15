package com.practice.security.dtos;

import com.practice.security.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestDto {

    private String username;

    private String email;

    private String password;

}
