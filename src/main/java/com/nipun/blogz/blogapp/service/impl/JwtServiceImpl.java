package com.nipun.blogz.blogapp.service.impl;

import com.nipun.blogz.blogapp.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtServiceImpl implements JwtService {
    @Override
    public String generateToken(String userName) {
        Map<String, Object> claims= new HashMap<>();
        return  createToken(claims,userName);
    }

        public static final String SECRET="4d69109a4d86a190b4a1d31c94a965a91ef3f10dbc1e1a12f45a8";





        private String createToken(Map<String, Object> claims, String userName){
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(userName)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis()+ 100*60*30))
                    .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
        }

        private Key getSignKey() {
            byte [] keyBytes= Decoders.BASE64.decode(SECRET);
            return Keys.hmacShaKeyFor(keyBytes);
        }
    }



