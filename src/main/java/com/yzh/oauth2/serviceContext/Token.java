package com.yzh.oauth2.serviceContext;

public interface Token {

    String X_TOKEN = "X-TOKEN";

    enum Claim {
        UserId("user_id");

        private final String key;

        Claim(String key) {
            this.key = key;
        }

        public String key(){
            return key;
        }
    }

    Long getUserId();
}
