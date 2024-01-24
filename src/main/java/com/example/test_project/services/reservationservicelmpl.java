package com.example.test_project.services;

import com.example.test_project.entities.Reservation;
import com.example.test_project.entities.User;
import com.example.test_project.reposiroty.ReservationRepository;
import com.example.test_project.reposiroty.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
@Service
public class reservationservicelmpl implements reservationservice {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private userrepository UserRepository; // Assuming you have a UserRepository

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
        // Implement update logic if needed
    }

    @Override
    public List<Reservation> getReservationsByUserId(String userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public String getUserEmailById(String userId) {
        Optional<User> optionalUser = UserRepository.findById(new BigInteger(userId));

        return optionalUser.map(User::getEmail).orElse(null);
    }

}



