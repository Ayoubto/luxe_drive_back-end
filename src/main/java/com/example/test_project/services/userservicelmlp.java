package com.example.test_project.services;

import com.example.test_project.entities.CustomUserDetails;
import com.example.test_project.entities.User;
import com.example.test_project.reposiroty.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class userservicelmlp implements userservice {

    @Autowired
    private userrepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Injection du PasswordEncoder
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));

        // Création de CustomUserDetails avec le prénom et le nom
        UserDetails userDetails = new CustomUserDetails(
                user.getEmail(),
                user.getPassword(),
                authorities,
                user.getNom(),  // Ajout du nom de l'utilisateur
                user.getPrenom(),  // Ajout du prénom de l'utilisateur
                user.getImage()
        );

        return userDetails;
    }

    @Autowired
    public userservicelmlp(userrepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;

    }





    public void saveUser(User user) {
        this.userRepository.save(user);

    }


    public void deleteUser(BigInteger id) {
        this.userRepository.deleteById(id);

    }


    @Override
    public Optional<User> getUserById(BigInteger id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

//    @Override
//    public void updateUser(BigInteger id) {
//
//    }



}
//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public User save(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword())); // Utilisation de passwordEncoder
//        return userRepository.save(user);
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                // Add roles or authorities if needed
//                Collections.emptyList()
//        );
//    }
//}
