package org.lcwd.user.service.controller;

import org.lcwd.user.service.entity.User;
import org.lcwd.user.service.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // create
    @PostMapping
    public ResponseEntity<User> createUser( @RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    // get single user
    @GetMapping("/{userID}")
    public ResponseEntity<User> getUser(@PathVariable String userID){
        User user1 = userService.getUser(userID);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    // get all user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
