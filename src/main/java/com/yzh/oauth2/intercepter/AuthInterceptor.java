package com.yzh.oauth2.intercepter;

import com.yzh.oauth2.serviceContext.Token;
import com.yzh.oauth2.serviceContext.YzhContextInternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {


    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        request.getHeader(Token.X_TOKEN);
//        String token = redisTemplate.boundGeoOps("");
        return false;
    }
}
