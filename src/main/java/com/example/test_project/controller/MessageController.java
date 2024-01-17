package com.example.test_project.controller;


import com.example.test_project.entities.Message;
import com.example.test_project.services.messageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    private final messageservice messageService;

    @Autowired
    public MessageController(messageservice messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/addmessage")
    public void addMessage(@RequestBody Message message) {
        messageService.saveMessage(message);
    }

    @PutMapping("/updatemessage/{id}")
    public ResponseEntity<String> updateMessage(@PathVariable BigInteger id, @RequestBody Message updateMessage) {
        Message existingMessage = messageService.getMessageById(id);

        if (existingMessage != null) {
            // Mettez à jour les champs nécessaires ici
            existingMessage.setNom_env(updateMessage.getNom_env());
            existingMessage.setPrenom_env(updateMessage.getPrenom_env());
            existingMessage.setEmail_env(updateMessage.getEmail_env());
            existingMessage.setTelephone_env(updateMessage.getTelephone_env());
            existingMessage.setObjet(updateMessage.getObjet());
            existingMessage.setContenu(updateMessage.getContenu());

            messageService.saveMessage(existingMessage);
//            return ResponseEntity.ok("Message updated successfully");
            String successMessage = "Messsage updated successfully";
            return ResponseEntity.ok().body("{\"message\":\""+successMessage+"\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletemessage/{id}")
    public void deleteMessage(@PathVariable BigInteger id) {
        messageService.deleteMessage(id);
    }

    @GetMapping("/getallmessages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/getmessage/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable BigInteger id) {
        Optional<Message> message = Optional.ofNullable(messageService.getMessageById(id));
        return message.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
