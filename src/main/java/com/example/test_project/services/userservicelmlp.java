package com.example.test_project.services;

import com.example.test_project.entities.User;
import com.example.test_project.reposiroty.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class userservicelmlp implements userservice {

    @Autowired
    private userrepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Injection du PasswordEncoder

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Utilisation de passwordEncoder
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                // Add roles or authorities if needed
                Collections.emptyList()
        );
    }
}
