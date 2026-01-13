package com.nhanthanhle.ecom.ecomservice.controller;

import com.nhanthanhle.ecom.ecomservice.entity.User;
import com.nhanthanhle.ecom.ecomservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user.getName(), user.getEmail(), user.getPassword());
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<User> showUsers() {
        return userService.getListUsers();
    }

}
