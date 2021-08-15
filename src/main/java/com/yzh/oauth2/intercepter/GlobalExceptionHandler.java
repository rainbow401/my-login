package com.yzh.oauth2.intercepter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 以下是系统的异常
     *
     * @param e
     * @return 异常的提醒信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception e) {
        e.printStackTrace();
        return "发生未知问题";
    }
}
