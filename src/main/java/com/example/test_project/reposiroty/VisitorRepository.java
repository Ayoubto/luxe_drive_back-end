package com.example.test_project.reposiroty;

import com.example.test_project.entities.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface VisitorRepository extends MongoRepository<Visitor, BigInteger> {
}
