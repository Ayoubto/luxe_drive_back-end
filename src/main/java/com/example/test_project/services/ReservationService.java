package com.example.test_project.services;

import com.example.test_project.entities.Reservation;

import java.math.BigInteger;
import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();

    Reservation getReservationById(BigInteger id);

    void saveReservation(Reservation reservation);

    void deleteReservation(BigInteger id);

    void updateReservation(BigInteger id);
}
