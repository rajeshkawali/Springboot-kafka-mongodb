package com.rajeshkawali.service;

import com.rajeshkawali.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public String sendSimpleMessage(User user);
    public String sendCallbackMessage(User user);
}
