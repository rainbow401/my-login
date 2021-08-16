package com.yzh.oauth2.controller;

import com.yzh.oauth2.Repository.UserRepository;
import com.yzh.oauth2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("saveUser")
    public String testMongo() {
        User user = new User();
        user.setId(1L);
        user.setName("yzh");
        user.setPassword("djiakjdka");
        user.setPhone("15589015587");
        return userRepository.save(user).toString();
    }
}
