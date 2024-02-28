package com.example.test_project.reposiroty;

import com.example.test_project.entities.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface ReservationRepository extends MongoRepository<Reservation, BigInteger> {
}
