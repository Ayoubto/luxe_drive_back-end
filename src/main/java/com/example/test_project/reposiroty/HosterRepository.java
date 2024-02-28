package com.example.test_project.reposiroty;

import com.example.test_project.entities.Admin;
import com.example.test_project.entities.Hoster;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface HosterRepository extends MongoRepository<Hoster, BigInteger> {
}
