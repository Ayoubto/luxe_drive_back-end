package com.example.test_project.controller;


import com.example.test_project.entities.Reservation;
import com.example.test_project.services.reservationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    private final reservationservice reservationService;

    @Autowired
    public ReservationController(reservationservice reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/addreservation")
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
    }

    @PutMapping("/updatereservation/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable BigInteger id, @RequestBody Reservation updateReservation) {
        Reservation existingReservation = reservationService.getReservationById(id);

        if (existingReservation != null) {
            if (updateReservation.getDateDebut() != null) {
                existingReservation.setDateDebut(updateReservation.getDateDebut());
            }

            if (updateReservation.getDateFin() != null) {
                existingReservation.setDateFin(updateReservation.getDateFin());
            }

            if (updateReservation.getAgence_depart_id() != null) {
                existingReservation.setAgence_depart_id(updateReservation.getAgence_depart_id());
            }

            if (updateReservation.getAgence_retour_id() != null) {
                existingReservation.setAgence_retour_id(updateReservation.getAgence_retour_id());
            }

            if (updateReservation.getVoiture_id() != null) {
                existingReservation.setVoiture_id(updateReservation.getVoiture_id());
            }

            if (updateReservation.getUser_id() != null) {
                existingReservation.setUser_id(updateReservation.getUser_id());
            }

            if (updateReservation.getStatus() != null) {
                existingReservation.setStatus(updateReservation.getStatus());
            }

            if (updateReservation.getReservation() != null) {
                existingReservation.setReservation(updateReservation.getReservation());
            }

            // Ajoutez les mises à jour pour les autres champs selon vos besoins

            reservationService.saveReservation(existingReservation);
            return ResponseEntity.ok("Reservation updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deletereservation/{id}")
    public void deleteReservation(@PathVariable BigInteger id) {
        reservationService.deleteReservation(id);
    }

    @GetMapping("/getallreservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllResevations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/getreservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable BigInteger id) {
        Optional<Reservation> reservation = Optional.ofNullable(reservationService.getReservationById(id));
        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
