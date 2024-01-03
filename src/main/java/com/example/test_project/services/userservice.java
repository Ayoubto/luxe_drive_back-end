package com.example.test_project.services;

import com.example.test_project.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


public interface userservice extends UserDetailsService {
//    static Optional<User> findById(BigInteger id) ;
User findByEmail(String email);

    User save(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(BigInteger id);
//    Optional<User> getUserById(BigInteger id);

    // Mettre à jour l'utilisateur
//    void updateUser(User user);

    void saveUser(User user);

    void deleteUser(BigInteger id);


    void updateUser(User user); // Mise à jour dynamique
//    User findByEmail(String email);
//     User save(User user);
//
//    List<User> getAllUsers();
//
//
//
//    void saveUser(User user);
//
//    void deleteUser(BigInteger id);
//
//    void updateUser(BigInteger id);
////    String getUserPrenom(UserDetails userDetails);
}
