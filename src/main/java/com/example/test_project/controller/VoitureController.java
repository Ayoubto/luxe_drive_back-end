package com.example.test_project.controller;


import com.example.test_project.entities.Voiture;
import com.example.test_project.services.voitureservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class VoitureController {

    @Autowired
    private voitureservice voitureService;

    @PostMapping("/addvoiture")
    public void addVoiture(@RequestBody Voiture voiture){
        voitureService.saveVoiture(voiture);
    }

    @PutMapping("/updatevoiture/{id}")
    public ResponseEntity<String> updateVoiture(@PathVariable BigInteger id, @RequestBody Voiture updateVoiture) {
        Voiture existingVoiture = voitureService.getVoitureById(id);

        if (existingVoiture != null) {
            if (updateVoiture.getImmatricule() != null) {
                existingVoiture.setImmatricule(updateVoiture.getImmatricule());
            }

            if (updateVoiture.getMarque() != null) {
                existingVoiture.setMarque(updateVoiture.getMarque());
            }

            if (updateVoiture.getModèle() != null) {
                existingVoiture.setModèle(updateVoiture.getModèle());
            }

            if (updateVoiture.getPrix() != 0) {
                existingVoiture.setPrix(updateVoiture.getPrix());
            }

            if (updateVoiture.getType() != null) {
                existingVoiture.setType(updateVoiture.getType());
            }

            if (updateVoiture.getNb_personnes() != 0) {
                existingVoiture.setNb_personnes(updateVoiture.getNb_personnes());
            }

            if (updateVoiture.getCarburant() != null) {
                existingVoiture.setCarburant(updateVoiture.getCarburant());
            }

            if (updateVoiture.getImg() != null) {
                existingVoiture.setImg(updateVoiture.getImg());
            }

            if (updateVoiture.getConsommation() != 0) {
                existingVoiture.setConsommation(updateVoiture.getConsommation());
            }

            if (updateVoiture.getAssurance() != null) {
                existingVoiture.setAssurance(updateVoiture.getAssurance());
            }

            voitureService.saveVoiture(existingVoiture);
            return ResponseEntity.ok("Voiture updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletevoiture/{id}")
    public void deleteVoiture(@PathVariable BigInteger id) {
        voitureService.deleteVoiture(id);
    }

    @GetMapping("/getallvoitures")
    public ResponseEntity<List<Voiture>>  getAllVoitures() {
        List<Voiture> voiture =voitureService.getAllVoitures();
        return ResponseEntity.ok(voiture);
    }

    @GetMapping("/getvoiture/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable BigInteger id) {
        Optional<Voiture> voiture = Optional.ofNullable(voitureService.getVoitureById(id));
        return voiture.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}


