package com.onlinehospital.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import javax.security.auth.*;

@Component
public class JwtUtil {

    private final String secretKey = "test-key";
    private final long expiration = 18000000;

    public String generateTokenByUsername(String username) {
        Date now = new Date();
        Date expDate = new Date(now.getTime() + expiration);

        return JWT.create()
                .withClaim("username", username)
                .withIssuedAt(now)
                .withExpiresAt(expDate)
                .sign(Algorithm.HMAC512(secretKey));
    }

    public String getClaimsFromToken(String token) {
        return JWT.require(Algorithm.HMAC512(secretKey))
                .build()
                .verify(token)
                .getClaim("username")
                .asString();
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC512(secretKey))
                    .build()
                    .verify(token);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

}
