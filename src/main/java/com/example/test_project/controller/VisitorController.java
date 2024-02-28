package com.example.test_project.controller;

import com.example.test_project.entities.Visitor;
import com.example.test_project.entities.VisitorResponseDTO;
import com.example.test_project.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping("/addvisitor")
    public void addVisitor(@RequestBody Visitor visitor) {
        visitorService.saveVisitor(visitor);
    }

    @PutMapping("/updatevisitor/{id}")
    public ResponseEntity<String> updateVisitor(@PathVariable BigInteger id, @RequestBody Visitor updateVisitor) {
        Visitor existingVisitor = visitorService.getVisitorById(id);

        if (existingVisitor != null) {
            // Update existingVisitor fields here
            if (updateVisitor.getName() != null) {
                existingVisitor.setName(updateVisitor.getName());
            }

            if (updateVisitor.getAdresse() != null) {
                existingVisitor.setAdresse(updateVisitor.getAdresse());
            }

            if (updateVisitor.getCni() != null) {
                existingVisitor.setCni(updateVisitor.getCni());
            }

            if (updateVisitor.getPhone_number() != null) {
                existingVisitor.setPhone_number(updateVisitor.getPhone_number());
            }

            if (updateVisitor.getRib() != null) {
                existingVisitor.setRib(updateVisitor.getRib());
            }

            if (updateVisitor.getAge() != 0) {
                existingVisitor.setAge(updateVisitor.getAge());
            }

            if (updateVisitor.getCategory() != null) {
                existingVisitor.setCategory(updateVisitor.getCategory());
            }

            if (updateVisitor.getUsername() != null) {
                existingVisitor.setUsername(updateVisitor.getUsername());
            }

            if (updateVisitor.getPassword() != null) {
                existingVisitor.setPassword(updateVisitor.getPassword());
            }

            if (updateVisitor.getNationality() != null) {
                existingVisitor.setNationality(updateVisitor.getNationality());
            }

            if (updateVisitor.getGender() != null) {
                existingVisitor.setGender(updateVisitor.getGender());
            }

            if (updateVisitor.getEmail() != null) {
                existingVisitor.setEmail(updateVisitor.getEmail());
            }

            visitorService.saveVisitor(existingVisitor);
            String successMessage = "Visitor updated successfully";
            return ResponseEntity.ok().body("{\"message\":\"" + successMessage + "\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletevisitor/{id}")
    public void deleteVisitor(@PathVariable BigInteger id) {
        visitorService.deleteVisitor(id);
    }

    @GetMapping("/getallvisitors")
    public ResponseEntity<List<VisitorResponseDTO>> getAllVisitors() {
        List<Visitor> visitors = visitorService.getAllVisitors();
        List<VisitorResponseDTO> visitorDTOs = convertVisitorsToResponseDTOs(visitors);
        return ResponseEntity.ok(visitorDTOs);
    }

    @GetMapping("/getvisitor/{id}")
    public ResponseEntity<VisitorResponseDTO> getVisitorById(@PathVariable BigInteger id) {
        Visitor visitor = visitorService.getVisitorById(id);
        if (visitor != null) {
            VisitorResponseDTO visitorDTO = convertVisitorToResponseDTO(visitor);
            return ResponseEntity.ok(visitorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private VisitorResponseDTO convertVisitorToResponseDTO(Visitor visitor) {
        return new VisitorResponseDTO(
                visitor.getId().toString(),
                visitor.getName(),
                visitor.getAdresse(),
                visitor.getCni(),
                visitor.getPhone_number(),
                visitor.getRib(),
                visitor.getAge(),
                visitor.getCategory(),
                visitor.getUsername(),
                visitor.getPassword(),
                visitor.getNationality(),
                visitor.getGender(),
                visitor.getEmail()
        );
    }

    private List<VisitorResponseDTO> convertVisitorsToResponseDTOs(List<Visitor> visitors) {
        return visitors.stream()
                .map(this::convertVisitorToResponseDTO)
                .collect(Collectors.toList());
    }
}
