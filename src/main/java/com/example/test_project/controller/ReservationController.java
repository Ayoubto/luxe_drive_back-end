package com.example.test_project.controller;


import com.example.test_project.entities.Reservation;
import com.example.test_project.entities.ReservationResponseDTO;
import com.example.test_project.services.reservationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
                existingReservation.setDateDebut((updateReservation.getDateDebut()));
            }

            if (updateReservation.getDateFin() != null) {
                existingReservation.setDateFin((updateReservation.getDateFin()));
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


            reservationService.saveReservation(existingReservation);

            String successMessage = "Reservation updated successfully";
            return ResponseEntity.ok().body("{\"message\":\""+successMessage+"\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deletereservation/{id}")
    public void deleteReservation(@PathVariable BigInteger id) {
        reservationService.deleteReservation(id);
    }
    @GetMapping("/getallreservations")
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllResevations();
        List<ReservationResponseDTO> reservationDTOs = convertReservationsToResponseDTOs(reservations);
        return ResponseEntity.ok(reservationDTOs);
    }
    @GetMapping("/getreservationsbyuser/{userId}")
    public ResponseEntity<List<ReservationResponseDTO>> getReservationsByUserId(@PathVariable String userId) {
        List<Reservation> reservations = reservationService.getReservationsByUserId(userId);

        if (reservations != null && !reservations.isEmpty()) {
            List<ReservationResponseDTO> reservationDTOs = convertReservationsToResponseDTOs(reservations);
            return ResponseEntity.ok(reservationDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getreservation/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservationById(@PathVariable BigInteger id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            ReservationResponseDTO reservationDTO = convertReservationToResponseDTO(reservation);
            return ResponseEntity.ok(reservationDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Ajoutez ces méthodes d'aide à votre contrôleur
    private ReservationResponseDTO convertReservationToResponseDTO(Reservation reservation) {
        return new ReservationResponseDTO(
                reservation.getId().toString(),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                reservation.getAgence_depart_id().toString(),
                reservation.getAgence_retour_id().toString(),
                reservation.getVoiture_id().toString(),
                reservation.getUser_id().toString(),
                reservation.getStatus(),
                reservation.getReservation()
        );
    }

    private List<ReservationResponseDTO> convertReservationsToResponseDTOs(List<Reservation> reservations) {
        return reservations.stream()
                .map(this::convertReservationToResponseDTO)
                .collect(Collectors.toList());
    }
    @PatchMapping("/updatestatus/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable String id){
        BigInteger reservationId = new BigInteger(id);
        Optional<Reservation> optionalReservation = Optional.ofNullable(reservationService.getReservationById(reservationId));

        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            String newStatus = "confirmée";
            reservation.setStatus(newStatus);
            reservationService.saveReservation(reservation);
            String successMessage = "Status updated successfully";
            return ResponseEntity.ok().body("{\"message\":\""+successMessage+"\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
