package com.example.test_project.services;

import com.example.test_project.entities.Hoster;
import com.example.test_project.reposiroty.HosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class HosterServiceImpl implements HosterService {

    private final HosterRepository hosterRepository;

    @Autowired
    public HosterServiceImpl(HosterRepository hosterRepository) {
        this.hosterRepository = hosterRepository;
    }

    @Override
    public List<Hoster> getAllHosters() {
        return hosterRepository.findAll();
    }

    @Override
    public Hoster getHosterById(BigInteger id) {
        return hosterRepository.findById(id).orElse(null);
    }

    @Override
    public void saveHoster(Hoster hoster) {
        hosterRepository.save(hoster);
    }

    @Override
    public void deleteHoster(BigInteger id) {
        hosterRepository.deleteById(id);
    }

    @Override
    public void updateHoster(BigInteger id) {
        // Implementation for updating a hoster
    }
}

