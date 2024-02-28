package com.example.test_project.reposiroty;



import com.example.test_project.entities.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface AdminRepository extends MongoRepository<Admin, BigInteger> {
}
