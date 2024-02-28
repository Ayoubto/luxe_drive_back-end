package com.example.test_project.services;

import com.example.test_project.entities.Reservation;
import com.example.test_project.reposiroty.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(BigInteger id) {
        return reservationRepository.findById(id).orElse(null);
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
        // Implementation for updating a reservation
    }
}
