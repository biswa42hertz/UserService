package com.example.UserService.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginPayload {
    private String username;
    private String password;
}
