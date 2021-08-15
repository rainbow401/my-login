package com.yzh.oauth2.controller;

import com.yzh.oauth2.Mapper.UserMapper;
import com.yzh.oauth2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * sdyzh1111
 */
@RestController("/user")
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("test")
    public String test(){
        redisTemplate.boundValueOps("key").set("value");
        String str1 = (String) redisTemplate.boundValueOps("key").get();


        User user = userMapper.selectById(1L);
        return user.toString();
    }
}
