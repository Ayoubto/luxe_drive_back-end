package com.example.test_project.controller;

import com.example.test_project.entities.Admin;
import com.example.test_project.entities.AdminResponseDTO;

import com.example.test_project.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/addadmin")
    public void addAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
    }

    @PutMapping("/updateadmin/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable BigInteger id, @RequestBody Admin updateAdmin) {
        Admin existingAdmin = adminService.getAdminById(id);

        if (existingAdmin != null) {
            // Update existingAdmin fields here
            if (updateAdmin.getName() != null) {
                existingAdmin.setName(updateAdmin.getName());
            }

            if (updateAdmin.getAdresse() != null) {
                existingAdmin.setAdresse(updateAdmin.getAdresse());
            }

            if (updateAdmin.getCni() != null) {
                existingAdmin.setCni(updateAdmin.getCni());
            }

            if (updateAdmin.getPhone_number() != null) {
                existingAdmin.setPhone_number(updateAdmin.getPhone_number());
            }

            if (updateAdmin.getAge() != 0) {
                existingAdmin.setAge(updateAdmin.getAge());
            }

            if (updateAdmin.getUsername() != null) {
                existingAdmin.setUsername(updateAdmin.getUsername());
            }

            if (updateAdmin.getPassword() != null) {
                existingAdmin.setPassword(updateAdmin.getPassword());
            }

            if (updateAdmin.getEmail() != null) {
                existingAdmin.setEmail(updateAdmin.getEmail());
            }

            // Continue updating other fields as needed...

            adminService.saveAdmin(existingAdmin);
            String successMessage = "Admin updated successfully";
            return ResponseEntity.ok().body("{\"message\":\"" + successMessage + "\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deleteadmin/{id}")
    public void deleteAdmin(@PathVariable BigInteger id) {
        adminService.deleteAdmin(id);
    }

    @GetMapping("/getalladmins")
    public ResponseEntity<List<AdminResponseDTO>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        List<AdminResponseDTO> adminDTOs = convertAdminsToResponseDTOs(admins);
        return ResponseEntity.ok(adminDTOs);
    }

    @GetMapping("/getadmin/{id}")
    public ResponseEntity<AdminResponseDTO> getAdminById(@PathVariable BigInteger id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            AdminResponseDTO adminDTO = convertAdminToResponseDTO(admin);
            return ResponseEntity.ok(adminDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private AdminResponseDTO convertAdminToResponseDTO(Admin admin) {
        return new AdminResponseDTO(
                admin.getId().toString(),
                admin.getName(),
                admin.getAdresse(),
                admin.getCni(),
                admin.getPhone_number(),
                admin.getAge(),
                admin.getUsername(),
                admin.getPassword(),
                admin.getEmail()
        );
    }

    private List<AdminResponseDTO> convertAdminsToResponseDTOs(List<Admin> admins) {
        return admins.stream()
                .map(this::convertAdminToResponseDTO)
                .collect(Collectors.toList());
    }
}
