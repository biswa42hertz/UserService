package com.example.UserService.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterPayload {

    private String name;

    private String username;

    private String password;

    public User toUser() {
        return User.builder().name(name).username(username).password(password).build();
    }

}
