package com.example.test_project.reposiroty;

import com.example.test_project.entities.Admin;
import com.example.test_project.entities.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface ListingRepository extends MongoRepository<Listing, BigInteger> {
}
