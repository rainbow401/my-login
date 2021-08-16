package com.yzh.oauth2.intercepter;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalExceptionHandlerAutoConfiguration {

    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
