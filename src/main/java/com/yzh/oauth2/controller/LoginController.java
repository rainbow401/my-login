package com.yzh.oauth2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yzh.oauth2.Mapper.UserMapper;
import com.yzh.oauth2.Utils.Md5Utils;
import com.yzh.oauth2.Utils.TokenUtils;
import com.yzh.oauth2.entity.User;
import com.yzh.oauth2.serviceContext.Token;
import com.yzh.oauth2.serviceContext.YzhContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.temporal.ChronoUnit;

@RestController("/login")
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private YzhContext yzhContext;


    @RequestMapping("login")
    public String login(User user) throws Exception {

        if(user.getPhone() == null || user.getPhone().length() != 11) {
            throw new Exception("参数有误");
        }

        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getPhone, user.getPhone());
        User dataUser = userMapper.selectOne(userQueryWrapper);
        String password = DigestUtils.md5DigestAsHex((user.getPassword() + Md5Utils.MD5_SECRET).getBytes(StandardCharsets.UTF_8));

        if(password.equals(dataUser.getPassword())) {
            String token = TokenUtils.generateToken(user.getId(), 1L, ChronoUnit.MINUTES);
            redisTemplate.boundValueOps(Token.X_TOKEN + ":" + user.getId()).set(token);
            return token;
        } else {
            return "密码错误";
        }
    }

//    @RequestMapping("test")
//    @ResponseBody
//    public Long test() {
//        return yzhContext.currentToken().getUserId();
//    }
}
