package com.example.demo.project2.controllers;

import com.example.demo.project2.entities.Project;
import com.example.demo.project2.entities.Users;
import com.example.demo.project2.exception.RequestException;
import com.example.demo.project2.repositories.UserRepository;
import com.example.demo.project2.services.UserService;
import com.example.demo.project2.views.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {

        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/getUser")
    public UserView getUserById(@RequestParam Integer id) throws RequestException {
        UserView userView = userService.getUser(id);
        return userView;
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody UserView userView) throws RequestException {
        userService.saveUser(userView);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<Users>> getAllProjects() throws RequestException{
        List<Users> users = userRepository.getAllUsers();
        if (users.isEmpty()) {
            throw new RequestException("No clients found");
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam Integer id) throws Exception{
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

}
