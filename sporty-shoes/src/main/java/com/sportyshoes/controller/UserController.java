package com.sportyshoes.controller;

import com.sportyshoes.dto.UserRequestDTO;
import com.sportyshoes.dto.UserResponseDTO;
import com.sportyshoes.entity.User;
import com.sportyshoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody UserRequestDTO user) {
        return userService.loginUser(user);
    }

    @PostMapping("/fetch")
    public ResponseEntity<UserResponseDTO> fetchUsers(@RequestBody User user, @RequestHeader String sessionId) {
        return userService.getAllUsers(user, sessionId);
    }


}
