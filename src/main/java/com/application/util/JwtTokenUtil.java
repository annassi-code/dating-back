package com.application.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
/*
    private static final String CLAIMS_SUBJECT = "sub";
    private static final String CLAIMS_CREATED = "created";
    private static Long TOKEN_VALIDITY;
    private static String TOKEN_SECRET;

    public static String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIMS_SUBJECT, userDetails.getUsername());
        claims.put(CLAIMS_CREATED, new Date());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .compact();
    }

    public static String getUserNameFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public static boolean isTokenValid(String token, UserDetails userDetails){
        String username = getUserNameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private static boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }

    private static Claims getClaims(String token){
        return Jwts.parser().setSigningKey(TOKEN_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
    }

    @Value("${jwt.secret}")
    private void setTokenSecret(String secret){
        TOKEN_SECRET = secret;
    }

    @Value("${jwt.expiration}")
    private void setTokenValidity(long validity){
        TOKEN_VALIDITY = validity;
    }
    */

}
