package com.example.test_project.controller;


import com.example.test_project.entities.User;
//import com.example.test_project.jwtconfigtocken.JwtUtil;
import com.example.test_project.jwtconfigtocken.JwtUtil;
import com.example.test_project.services.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;


@RestController
@RequestMapping("/api/auth")
public class usercontroller {
    @Autowired
    private userservice userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        // Vérifie si le nom d'utilisateur est déjà pris
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        // Enregistre l'utilisateur
        userService.save(user);

        // Génère le token JWT après l'inscription réussie
        final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(jwt); // Renvoie le token JWT
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        try {
            // Tente l'authentification
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (BadCredentialsException e) {
            // En cas d'informations d'identification invalides
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        // Si l'authentification est réussie, génère le token JWT
        final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(jwt); // Renvoie le token JWT
    }
}





//    @Autowired
//    private userservice userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<String> signUp(@RequestBody User user) {
//        if (userService.findByUsername(user.getUsername()) != null) {
//            return ResponseEntity.badRequest().body("Username is already taken");
//        }
//        userService.save(user);
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<String> signIn(@RequestBody User user) {
//        User foundUser = userService.findByUsername(user.getUsername());
//        if (foundUser == null || !foundUser.getPassword().equals(user.getPassword())) {
//            throw new UsernameNotFoundException("Invalid username or password");
//        }
//        return ResponseEntity.ok("User signed in successfully");
//    }
//}
