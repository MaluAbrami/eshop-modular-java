package org.eshop.eshop.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final Key key;
    private final long expiration;

    public JwtTokenProvider(@Value("jwtsecret") String secret,@Value("expiration-ms") long expiration) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expiration;
    }

    public String generateToken(String subject) {
        var now = new Date();
        var exp = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key)
                .compact();
    }
}
