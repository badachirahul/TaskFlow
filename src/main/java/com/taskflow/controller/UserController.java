package com.taskflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.entity.User;
import com.taskflow.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User user1 = userService.addUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId")int userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @DeleteMapping("{userId}")
    public List<User> deleteUserById(@PathVariable("userId")int userId) {
        return userService.deleteUserById(userId);
    }

}