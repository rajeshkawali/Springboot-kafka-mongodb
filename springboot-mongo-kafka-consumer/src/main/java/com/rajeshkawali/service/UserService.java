package com.rajeshkawali.service;

import com.rajeshkawali.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public void consumeUser(User user);
    public List<User> getAllUsers();
}
