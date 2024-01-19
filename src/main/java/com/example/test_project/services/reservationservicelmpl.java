package com.example.test_project.services;

import com.example.test_project.entities.Reservation;
import com.example.test_project.reposiroty.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class reservationservicelmpl implements reservationservice {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllResevations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(BigInteger id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        return optionalReservation.orElse(null);
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(BigInteger id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void updateReservation(BigInteger id) {
        // Votre logique de mise à jour ici
        // Vous pouvez récupérer la réservation, apporter des modifications et sauvegarder à nouveau
    }
}