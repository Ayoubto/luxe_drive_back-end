package com.example.test_project.services;


import com.example.test_project.entities.Admin;

import java.math.BigInteger;
import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmins();

    Admin getAdminById(BigInteger id);

    void saveAdmin(Admin admin);

    void deleteAdmin(BigInteger id);

    void updateAdmin(BigInteger id);
}
