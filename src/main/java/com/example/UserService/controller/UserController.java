package com.example.UserService.controller;

import com.example.UserService.model.UserLoginPayload;
import com.example.UserService.model.UserRegisterPayload;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

@Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
            @RequestParam(required = false) String locale,
            @RequestBody UserLoginPayload userLogin) {
        int statusCode = 200;
        String msg = "Login successful";
        String isValidUser = userService.loginUser(userLogin);
        if(isValidUser != "") {
            statusCode = 500;
            msg = "Login failed with error : "+isValidUser;
        }
        return ResponseEntity.status(statusCode).body(msg);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(
            @RequestParam(required = false) String locale,
            @RequestBody UserRegisterPayload userRegister) {

        userService.registerUser(userRegister);
        return ResponseEntity.status(200).body("User signup succesfull");
    }

}
