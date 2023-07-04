package com.example.demo.project2.controllers;

import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.services.ClientService;
import com.example.demo.project2.services.UserService;
import com.example.demo.project2.views.ClientView;
import com.example.demo.project2.views.UserView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public UserView getClientById(@RequestParam Integer id) throws RequestException {
        UserView userView = userService.getUser(id);
        return userView;
    }
}
