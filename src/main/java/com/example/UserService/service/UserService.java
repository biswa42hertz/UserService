package com.example.UserService.service;

import com.example.UserService.model.User;
import com.example.UserService.model.UserLoginPayload;
import com.example.UserService.model.UserRegisterPayload;
import com.example.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

@Autowired
    UserRepository userRepository;

public String registerUser(UserRegisterPayload registerUser) {
    // Validate the new user
    userRepository.save(registerUser.toUser());
    return "User registered successfully";
}

public String loginUser(UserLoginPayload loginRequest) {

    Optional<User> user = userRepository.findByUserName(loginRequest.getUsername()).stream().findFirst();
    if(user.isPresent()) {
        if(loginRequest.getPassword().equals(user.get().getPassword()))
            return "";
        else
            return "Username or password not correct";
    } else {
        return "No user found with the username:"+loginRequest.getUsername();
    }
}
}
