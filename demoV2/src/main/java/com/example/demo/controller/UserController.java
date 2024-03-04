package com.example.demo.controller;


import com.example.demo.models.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/user")
    public User createUser(@RequestBody User request) {
       return userService.addUser(request);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }
}