package com.example.test_project.controller;

import com.example.test_project.entities.Reservation;
import com.example.test_project.entities.ReservationResponseDTO;
import com.example.test_project.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
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
            // Update existingReservation fields here
            if (updateReservation.getStatus() != null) {
                existingReservation.setStatus(updateReservation.getStatus());
            }

            if (updateReservation.getBookingDate() != null) {
                existingReservation.setBookingDate(updateReservation.getBookingDate());
            }

            if (updateReservation.getHoster_id() != null) {
                existingReservation.setHoster_id(updateReservation.getHoster_id());
            }

            if (updateReservation.getVisitor_id() != null) {
                existingReservation.setVisitor_id(updateReservation.getVisitor_id());
            }

            if (updateReservation.getListing_id() != null) {
                existingReservation.setListing_id(updateReservation.getListing_id());
            }

            reservationService.saveReservation(existingReservation);
            String successMessage = "Reservation updated successfully";
            return ResponseEntity.ok().body("{\"message\":\"" + successMessage + "\"}");
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
        List<Reservation> reservations = reservationService.getAllReservations();
        List<ReservationResponseDTO> reservationDTOs = convertReservationsToResponseDTOs(reservations);
        return ResponseEntity.ok(reservationDTOs);
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

    private ReservationResponseDTO convertReservationToResponseDTO(Reservation reservation) {
        return new ReservationResponseDTO(
                reservation.getId().toString(),
                reservation.getStatus(),
                reservation.getBookingDate(),
                reservation.getHoster_id().toString(),
                reservation.getVisitor_id().toString(),
                reservation.getListing_id().toString()
        );
    }

    private List<ReservationResponseDTO> convertReservationsToResponseDTOs(List<Reservation> reservations) {
        return reservations.stream()
                .map(this::convertReservationToResponseDTO)
                .collect(Collectors.toList());
    }
}
