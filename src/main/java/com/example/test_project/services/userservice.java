package com.example.test_project.services;

import com.example.test_project.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface userservice extends UserDetailsService {
    User findByUsername(String username);
    User save(User user);
}

