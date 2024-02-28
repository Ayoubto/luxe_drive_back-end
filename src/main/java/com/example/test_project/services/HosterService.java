package com.example.test_project.services;


import com.example.test_project.entities.Hoster;

import java.math.BigInteger;
import java.util.List;

public interface HosterService {
    List<Hoster> getAllHosters();

    Hoster getHosterById(BigInteger id);

    void saveHoster(Hoster hoster);

    void deleteHoster(BigInteger id);

    void updateHoster(BigInteger id);
}
