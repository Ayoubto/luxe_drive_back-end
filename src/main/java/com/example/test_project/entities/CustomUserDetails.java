package com.example.test_project.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {
    private final String nom;
    private final String prenom;
    private final String image;

//    public CustomUserDetails(String username, String password, String image, Collection<? extends GrantedAuthority> authorities, String nom, String prenom,  String image1) {
//        super(username, password,image1 ,authorities);
//        this.nom = nom;
//        this.prenom = prenom;
//        this.image = image1;
//    }

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String nom, String prenom, String image) {
        super(username, password, authorities);
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getImage() {
        return image;
    }
}
