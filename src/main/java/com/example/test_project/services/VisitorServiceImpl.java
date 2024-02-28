package com.example.test_project.services;

import com.example.test_project.entities.Visitor;
import com.example.test_project.reposiroty.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor getVisitorById(BigInteger id) {
        return visitorRepository.findById(id).orElse(null);
    }

    @Override
    public void saveVisitor(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    @Override
    public void deleteVisitor(BigInteger id) {
        visitorRepository.deleteById(id);
    }

    @Override
    public void updateVisitor(BigInteger id) {
        // Implementation for updating a visitor
    }
}
