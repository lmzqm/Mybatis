package com.lmzqm.mybatis.Server;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

/**
 * Created by lmzqm on 2017/7/25.
 */
@Service
public class TokenServer {

    private final String key = "jdksiejdoehdoesdkfofdk";

    public String getToken(Map<String,Object> claims){

        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();

        return token;
    }

    public Claims praseToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        }catch (SignatureException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean checkClaims(Claims claims){

        return  true;
    }




}
