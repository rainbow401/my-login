package com.yzh.oauth2.intercepter;

import com.yzh.oauth2.serviceContext.YzhContextInternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YzhContextInternalInterceptor implements HandlerInterceptor {

    @Autowired
    private YzhContextInternal yzhContextInternal;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        yzhContextInternal.extractContext(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        yzhContextInternal.clearContext();
    }
}
