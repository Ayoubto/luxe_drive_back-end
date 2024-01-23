package com.example.test_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendWelcomeEmail(String username, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Bienvenue, " + username + "!");
        message.setText("Bonjour " + username + ",\n\nVoici votre code pour continuer votre authentification.\n\n[Insérez le code ici]");

        javaMailSender.send(message);
    }
}
