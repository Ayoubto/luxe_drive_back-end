package com.example.test_project.services;

import com.example.test_project.entities.Visitor;

import java.math.BigInteger;
import java.util.List;

public interface VisitorService {
    List<Visitor> getAllVisitors();

    Visitor getVisitorById(BigInteger id);

    void saveVisitor(Visitor visitor);

    void deleteVisitor(BigInteger id);

    void updateVisitor(BigInteger id);
}
