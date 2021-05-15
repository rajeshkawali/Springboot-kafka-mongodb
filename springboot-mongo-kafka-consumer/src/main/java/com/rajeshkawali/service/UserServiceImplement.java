package com.rajeshkawali.service;

import com.rajeshkawali.entity.User;
import com.rajeshkawali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "myTopic", groupId = "user_group", containerFactory = "userKafkaListenerFactory")
    public void consumeUser(User user) {
        System.out.println("Consumed User JSON Message: " + user.toString());
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> user = userRepository.findAll();
        return user;
    }
}
