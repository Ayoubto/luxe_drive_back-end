package com.example.test_project.reposiroty;


import com.example.test_project.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

//public interface userrepository extends MongoRepository<User, Long> {
//    User findByUsername(String username);
//}
//package com.example.test_project.repository;
//
//import com.example.test_project.entities.User;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
public interface userrepository extends MongoRepository<User, ObjectId> {
    User findByEmail(String email);
}
