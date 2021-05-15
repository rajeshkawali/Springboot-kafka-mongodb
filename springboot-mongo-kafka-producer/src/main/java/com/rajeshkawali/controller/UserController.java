package com.rajeshkawali.controller;

import com.rajeshkawali.entity.User;
import com.rajeshkawali.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/producer/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, users.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/publish")
    public String sendSimpleMessage(@RequestBody User user) {
        return userService.sendSimpleMessage(user);
    }

    @PostMapping("/publish/callback")
    public String sendCallbackMessage(@RequestBody User user) {
        return userService.sendCallbackMessage(user);
    }

}
