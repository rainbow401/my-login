package com.yzh.oauth2.serviceContext;

import javax.servlet.http.HttpServletRequest;

public interface YzhContextInternal {

    void extractContext(HttpServletRequest request);

    void clearContext();
}
