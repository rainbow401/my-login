package com.yzh.oauth2.serviceContext;

import org.springframework.stereotype.Service;

@Service
public interface YzhContext extends YzhContextInternal{

    String HEADER_DOMAIN_ID = "X-DomainId";

    Token currentToken();

    Long currentDomainId();
}
