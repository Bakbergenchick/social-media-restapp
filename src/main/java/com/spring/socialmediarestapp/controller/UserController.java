package com.spring.socialmediarestapp.controller;

import com.spring.socialmediarestapp.service.UserService;
import com.spring.socialmediarestapp.utils.request.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){

        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.OK);
    }
}
