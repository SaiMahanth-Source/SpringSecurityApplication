package org.mahanth.springsecurityapplication.controller;

import org.mahanth.springsecurityapplication.model.User;
import org.mahanth.springsecurityapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> UserRegister(@RequestBody User user){

        return new ResponseEntity<>(userService.UserRegister(user), HttpStatus.CREATED);
    }
}
