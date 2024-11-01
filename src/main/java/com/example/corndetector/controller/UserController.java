package com.example.corndetector.controller;

import com.example.corndetector.entity.User;
import com.example.corndetector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User getUserInfoAPI(@PathVariable int id){
        return userService.getUserInfo(id);
    }
}
