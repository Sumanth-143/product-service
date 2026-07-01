package com.example.productservice.controller;

import com.example.productservice.model.User;
import com.example.productservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(User user) {
        return "Success";
    }

}
