package com.example.test_project.jwtconfigtocken;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "adnanelhayanijwtadnanelhayanijwtadnanelhayanijwt"; // Clé secrète JWT

//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//
//        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//        List<String> roles = authorities.stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//        // Ajoutez les rôles à la map des revendications
//        claims.put("roles", roles);
//
//        return createToken(claims, userDetails.getUsername());
//    }
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 heures d'expiration
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Autres méthodes pour valider le token, extraire des informations du token, etc.
}
