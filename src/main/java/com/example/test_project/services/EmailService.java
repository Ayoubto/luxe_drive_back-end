package com.example.test_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


        @Autowired
        private JavaMailSender javaMailSender;

        public void sendWelcomeEmail(String username, String email, String activationLink) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Bienvenue, " + username + "!");
            message.setText("Cher(e) " + username + ",\n\n" +
                    "Bienvenue sur notre plateforme! \n" +
                    "Nous avons reçu une demande de création de votre compte. Afin de compléter le processus, veuillez utiliser le lien d'authentification ci-dessous :\n" +
                    "Lien d'authentification : " + activationLink +"\n\n"+
                    "Assurez-vous de ne partager ce lien avec personne et de ne l'utiliser que dans le cadre de l'activation de l'authentification à deux facteurs pour votre compte.\n"+
                     "Merci de nous avoir choisis chez LuxeDrive!");

            javaMailSender.send(message);
        }


}
