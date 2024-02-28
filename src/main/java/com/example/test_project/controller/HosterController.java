package com.example.test_project.controller;

import com.example.test_project.entities.Hoster;
import com.example.test_project.entities.HosterResponseDTO;
import com.example.test_project.services.HosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HosterController {

    private final HosterService hosterService;

    @Autowired
    public HosterController(HosterService hosterService) {
        this.hosterService = hosterService;
    }

    @PostMapping("/addhoster")
    public void addHoster(@RequestBody Hoster hoster) {
        hosterService.saveHoster(hoster);
    }

    @PutMapping("/updatehoster/{id}")
    public ResponseEntity<String> updateHoster(@PathVariable BigInteger id, @RequestBody Hoster updateHoster) {
        Hoster existingHoster = hosterService.getHosterById(id);

        if (existingHoster != null) {
            // Update existingHoster fields here
            if (updateHoster.getName() != null) {
                existingHoster.setName(updateHoster.getName());
            }

            if (updateHoster.getAdresse() != null) {
                existingHoster.setAdresse(updateHoster.getAdresse());
            }

            if (updateHoster.getCni() != null) {
                existingHoster.setCni(updateHoster.getCni());
            }

            if (updateHoster.getPhone_number() != null) {
                existingHoster.setPhone_number(updateHoster.getPhone_number());
            }

            if (updateHoster.getRib() != null) {
                existingHoster.setRib(updateHoster.getRib());
            }

            if (updateHoster.getAge() != 0) {
                existingHoster.setAge(updateHoster.getAge());
            }

            if (updateHoster.getCategory() != null) {
                existingHoster.setCategory(updateHoster.getCategory());
            }

            if (updateHoster.getUsername() != null) {
                existingHoster.setUsername(updateHoster.getUsername());
            }

            if (updateHoster.getPassword() != null) {
                existingHoster.setPassword(updateHoster.getPassword());
            }

            if (updateHoster.getEmail() != null) {
                existingHoster.setEmail(updateHoster.getEmail());
            }

            if (updateHoster.getRole() != null) {
                existingHoster.setRole(updateHoster.getRole());
            }

            // Continue updating other fields as needed...

            hosterService.saveHoster(existingHoster);
            String successMessage = "Hoster updated successfully";
            return ResponseEntity.ok().body("{\"message\":\"" + successMessage + "\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deletehoster/{id}")
    public void deleteHoster(@PathVariable BigInteger id) {
        hosterService.deleteHoster(id);
    }

    @GetMapping("/getallhosters")
    public ResponseEntity<List<HosterResponseDTO>> getAllHosters() {
        List<Hoster> hosters = hosterService.getAllHosters();
        List<HosterResponseDTO> hosterDTOs = convertHostersToResponseDTOs(hosters);
        return ResponseEntity.ok(hosterDTOs);
    }

    @GetMapping("/gethoster/{id}")
    public ResponseEntity<HosterResponseDTO> getHosterById(@PathVariable BigInteger id) {
        Hoster hoster = hosterService.getHosterById(id);
        if (hoster != null) {
            HosterResponseDTO hosterDTO = convertHosterToResponseDTO(hoster);
            return ResponseEntity.ok(hosterDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private HosterResponseDTO convertHosterToResponseDTO(Hoster hoster) {
        return new HosterResponseDTO(
                hoster.getId().toString(),
                hoster.getName(),
                hoster.getAdresse(),
                hoster.getCni(),
                hoster.getPhone_number(),
                hoster.getRib(),
                hoster.getAge(),
                hoster.getCategory(),
                hoster.getUsername(),
                hoster.getPassword(),
                hoster.getEmail(),
                hoster.getRole()
        );
    }

    private List<HosterResponseDTO> convertHostersToResponseDTOs(List<Hoster> hosters) {
        return hosters.stream()
                .map(this::convertHosterToResponseDTO)
                .collect(Collectors.toList());
    }
}
