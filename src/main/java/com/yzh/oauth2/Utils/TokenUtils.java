package com.yzh.oauth2.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yzh.oauth2.serviceContext.Token;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.io.UnsupportedEncodingException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TokenUtils {

    public static final String secret = "sda=][[,kk423-78389-039,.,.24653621%##$@*";

    public static final Long expire_time = 1800L;

    private static class DecodedToken implements Token {
        private final Long userId;

        public DecodedToken(Long userId) {
            this.userId = userId;
        }

        @Override
        public Long getUserId() {
            return userId;
        }
    }

    public static Token extract(String token) {
        DecodedJWT tmp = JWT.decode(token);
        Claim claim = tmp.getClaim(Token.Claim.UserId.key());
        Long userId = Long.parseLong(claim.asString());

        return new DecodedToken(userId);
    }

    public static String generateToken(Long userId, long duration, ChronoUnit unit) throws UnsupportedEncodingException {
        return JWT.create()
                .withClaim(Token.Claim.UserId.key(), userId.toString())
                .withExpiresAt(Date.from(new Date().toInstant().plus(duration, unit)))
                .sign(Algorithm.HMAC256(secret));
    }
}
