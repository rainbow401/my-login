package com.yzh.oauth2.intercepter;

import com.yzh.oauth2.serviceContext.YzhContext;
import com.yzh.oauth2.serviceContext.YzhContextImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorHandlerAutoConfiguration implements WebMvcConfigurer {

    @Bean
    public YzhContext yzhContext() {
        return new YzhContextImpl();
    }

    @Bean
    public YzhContextInternalInterceptor yzhContextInternalInterceptor() {
        return new YzhContextInternalInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(yzhContextInternalInterceptor());
    }
}
