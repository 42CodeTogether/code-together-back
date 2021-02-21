package com.codetogether.CodeTogether.controller;

import com.codetogether.CodeTogether.domain.User;
import com.codetogether.CodeTogether.service.UserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/user")
    public Optional<User> get(String user) {
        return userService.find(user);
    }

    @PostMapping("api/user")
    public Optional<User> create(String intraId) {
        User user = new User(intraId);
        userService.save(user);
        return Optional.ofNullable(user);
    }
}
