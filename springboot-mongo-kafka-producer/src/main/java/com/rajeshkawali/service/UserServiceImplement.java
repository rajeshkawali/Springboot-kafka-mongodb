package com.rajeshkawali.service;

import com.rajeshkawali.entity.User;
import com.rajeshkawali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;

@Service
public class UserServiceImplement implements UserService{
    private static final String topicName = "myTopic";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public List<User> getAllUsers() {
        List<User> user = userRepository.findAll();
        return user;
    }

    public String sendSimpleMessage(User user) {
        userRepository.save(user);
        kafkaTemplate.send(topicName, user);
        return "Success";
    }

    public String sendCallbackMessage(User user) {
        userRepository.save(user);
        ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(topicName, user);
        future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
            public void onSuccess(SendResult<String, User> result) {
                System.out.println("Sent message=[" + user.getName() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + user.getName() + "] due to : " + ex.getMessage());
            }
        });
        return "Success";
    }
}

