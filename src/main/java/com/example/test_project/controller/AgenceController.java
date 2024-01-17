package com.example.test_project.controller;


import com.example.test_project.entities.Agence;
import com.example.test_project.services.agenceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class AgenceController {

    private final agenceservice agenceService;

    @Autowired
    public AgenceController(agenceservice agenceService) {
        this.agenceService = agenceService;
    }

    @PostMapping("/addagence")
    public void addAgence(@RequestBody Agence agence){
        agenceService.saveAgence(agence);
    }

    @PutMapping("/updateagence/{id}")
    public ResponseEntity<String> updateAgence(@PathVariable BigInteger id, @RequestBody Agence updateAgence) {
        Agence existingAgence = agenceService.getAgenceById(id);

        if (existingAgence != null) {
            if (updateAgence.getNom() != null) {
                existingAgence.setNom(updateAgence.getNom());
            }

            if (updateAgence.getAdresse() != null) {
                existingAgence.setAdresse(updateAgence.getAdresse());
            }

            if (updateAgence.getTelephone() != null) {
                existingAgence.setTelephone(updateAgence.getTelephone());
            }

            if (updateAgence.getEmail() != null) {
                existingAgence.setEmail(updateAgence.getEmail());
            }

            if (updateAgence.getLocalisation() != null) {
                existingAgence.setLocalisation(updateAgence.getLocalisation());
            }

            agenceService.saveAgence(existingAgence);
//            return ResponseEntity.ok("Agence updated successfully");
            String successMessage = "Agence updated successfully";
            return ResponseEntity.ok().body("{\"message\":\""+successMessage+"\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deleteagence/{id}")
    public void deleteAgence(@PathVariable BigInteger id) {
        agenceService.deleteAgence(id);
    }

    @GetMapping("/getallagences")
    public ResponseEntity<List<Agence>> getAllAgences() {
        List<Agence> agences = agenceService.getAllAgences();
        return ResponseEntity.ok(agences);
    }

    @GetMapping("/getagence/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable BigInteger id) {
        Optional<Agence> agence = Optional.ofNullable(agenceService.getAgenceById(id));
        return agence.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
