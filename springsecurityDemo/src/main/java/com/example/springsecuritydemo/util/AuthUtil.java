package com.example.springsecuritydemo.util;

import com.example.springsecuritydemo.enitity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;


import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class AuthUtil {
    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(User user){
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId",user.getId().toString())
                .claim("role", user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .signWith(getSecretKey())
                .compact();

    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
