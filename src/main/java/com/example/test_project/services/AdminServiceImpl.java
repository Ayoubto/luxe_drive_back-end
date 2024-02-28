package com.example.test_project.services;


import com.example.test_project.entities.Admin;

import com.example.test_project.reposiroty.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(BigInteger id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(BigInteger id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void updateAdmin(BigInteger id) {
        // Implementation for updating an admin
    }
}
