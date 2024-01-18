package com.example.test_project.controller;


import com.example.test_project.entities.CustomUserDetails;
import com.example.test_project.entities.User;
import com.example.test_project.jwtconfigtocken.JwtUtil;
import com.example.test_project.services.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

class JwtResponse {
    private final String jwt;
    private final String id;
    private final String email;
    private final String role;
    private String prenom; // Ajout du champ prenom
    private String nom; // Ajout du champ nom
    private String image;

    public JwtResponse(String jwt, String id, String email, String role) {
        this.jwt = jwt;
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJwt() {
        return jwt;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}


//    public String getJwt() {
//        return jwt;
//    }

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
    public ResponseEntity<JwtResponse> signUp(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body(new JwtResponse("Email is already taken",null,"",""));
        }

        // Vérification du champ rôle
        String role = (user.getRole() == null || user.getRole().isEmpty()) ? "user" : user.getRole();

        // Définir le rôle par défaut si le champ est vide
        user.setRole(role);

        userService.save(user);

        final UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        JwtResponse response = new JwtResponse(jwt,null,"", role); // Utilisation du rôle défini
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signIn(@RequestBody User user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );

            UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
            String jwt = jwtUtil.generateToken(userDetails);
            String role = getUserRole(userDetails);
            String username = userDetails.getUsername();
            String userId = ((CustomUserDetails) userDetails).getId();

            String prenom = ((CustomUserDetails) userDetails).getPrenom();
            String nom = ((CustomUserDetails) userDetails).getNom();
            String image = ((CustomUserDetails) userDetails).getImage(); // Récupération de l'image

            // Création de JwtResponse avec l'image
            JwtResponse response = new JwtResponse(jwt, userId, username, role);
            response.setPrenom(prenom);
            response.setNom(nom);
            response.setImage(image); // Utilisation de setImage() pour assigner l'image
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            String errorMessage = "Invalid email or password";
            return ResponseEntity.badRequest().body(new JwtResponse("Invalid email or password", null, "", ""));
        }
    }


    private String getUserRole(UserDetails userDetails) {
        return userDetails.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse(null);
    }


    private Long getUserId(UserDetails userDetails) {
        // Logique pour extraire l'ID de l'utilisateur depuis UserDetails
        // Vous devrez implémenter cette logique en fonction de la manière dont vous gérez les ID des utilisateurs
        return null;

}

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable BigInteger id, @RequestBody User updateUser) {
        Optional<User> existingUserOptional = userService.getUserById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            // Mettre à jour les champs du user
            if (updateUser.getNom() != null) {
                existingUser.setNom(updateUser.getNom());
            }

            if (updateUser.getPrenom() != null) {
                existingUser.setPrenom(updateUser.getPrenom());
            }

            if (updateUser.getAddress() != null) {
                existingUser.setAddress(updateUser.getAddress());
            }

            if (updateUser.getTelephone() != null) {
                existingUser.setTelephone(updateUser.getTelephone());
            }

            if (updateUser.getEmail() != null) {
                existingUser.setEmail(updateUser.getEmail());
            }

            if (updateUser.getPassword() != null) {
                existingUser.setPassword(updateUser.getPassword());
            }

            userService.updateUser(existingUser); // Appel de la méthode updateUser du service
            String successMessage = "User updated successfully";
            return ResponseEntity.ok().body("{\"message\":\"" + successMessage + "\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable BigInteger id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getallusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable BigInteger id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and setters for status and message
    // ...
}}




