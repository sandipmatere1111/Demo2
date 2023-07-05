package com.example.demo.project2.controllers;

import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.services.ClientService;
import com.example.demo.project2.services.UserService;
import com.example.demo.project2.views.ClientView;
import com.example.demo.project2.views.ProjectView;
import com.example.demo.project2.views.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/getUser")
    public UserView getUserById(@RequestParam Integer id) throws RequestException {
        UserView userView = userService.getUser(id);
        return userView;
    }

    @GetMapping("/saveUser")
    public void saveUser(@RequestBody UserView userView) throws RequestException {
        userService.saveUser(userView);
    }

    @GetMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam Integer id) throws Exception{
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

}
