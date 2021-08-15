package com.yzh.oauth2.serviceContext;

import com.yzh.oauth2.Utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public class YzhContextImpl implements YzhContext{

    private static final ThreadLocal<Token> token = new ThreadLocal<>();
    private static final ThreadLocal<Long> domainId = new ThreadLocal<>();


    @Override
    public Long currentDomainId() {
        return domainId.get();
    }

    @Override
    public Token currentToken() {
        return token.get();
    }

    @Override

    public void extractContext(HttpServletRequest request) {
        String tokenString = request.getHeader(Token.X_TOKEN);
        Token token = tokenString != null ? TokenUtils.extract(tokenString) : null;

        String domainIdString = request.getHeader(HEADER_DOMAIN_ID);
        Long domainId = null;

        try {
            if (domainIdString != null) {
                domainId = Long.parseLong(domainIdString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (token != null) {
            YzhContextImpl.token.set(token);
        }

        if (domainId != null) {
            YzhContextImpl.domainId.set(domainId);
        }



    }

    @Override
    public void clearContext() {
        token.remove();
        domainId.remove();
    }


}
