package com.example.test_project.controller;

import com.example.test_project.entities.Listing;
import com.example.test_project.entities.ListingResponseDTO;
import com.example.test_project.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping("/addlisting")
    public void addListing(@RequestBody Listing listing) {
        listingService.saveListing(listing);
    }

    @PutMapping("/updatelisting/{id}")
    public ResponseEntity<String> updateListing(@PathVariable BigInteger id, @RequestBody Listing updateListing) {
        Listing existingListing = listingService.getListingById(id);

        if (existingListing != null) {
            // Update existingListing fields here
            if (updateListing.getImage() != null) {
                existingListing.setImage(updateListing.getImage());
            }

            if (updateListing.getTitle() != null) {
                existingListing.setTitle(updateListing.getTitle());
            }

            if (updateListing.getDescription() != null) {
                existingListing.setDescription(updateListing.getDescription());
            }

            if (updateListing.getDate() != null) {
                existingListing.setDate(updateListing.getDate());
            }

            if (updateListing.getPrice() != 0) {
                existingListing.setPrice(updateListing.getPrice());
            }

            if (updateListing.getStatus() != null) {
                existingListing.setStatus(updateListing.getStatus());
            }

            if (updateListing.getReview() != null) {
                existingListing.setReview(updateListing.getReview());
            }

            if (updateListing.getHosterId() != null) {
                existingListing.setHosterId(updateListing.getHosterId());
            }

            // Continue updating other fields as needed...

            listingService.saveListing(existingListing);
            String successMessage = "Listing updated successfully";
            return ResponseEntity.ok().body("{\"message\":\"" + successMessage + "\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletelisting/{id}")
    public void deleteListing(@PathVariable BigInteger id) {
        listingService.deleteListing(id);
    }

    @GetMapping("/getalllistings")
    public ResponseEntity<List<ListingResponseDTO>> getAllListings() {
        List<Listing> listings = listingService.getAllListings();
        List<ListingResponseDTO> listingDTOs = convertListingsToResponseDTOs(listings);
        return ResponseEntity.ok(listingDTOs);
    }

    @GetMapping("/getlisting/{id}")
    public ResponseEntity<ListingResponseDTO> getListingById(@PathVariable BigInteger id) {
        Listing listing = listingService.getListingById(id);
        if (listing != null) {
            ListingResponseDTO listingDTO = convertListingToResponseDTO(listing);
            return ResponseEntity.ok(listingDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private ListingResponseDTO convertListingToResponseDTO(Listing listing) {
        return new ListingResponseDTO(
                listing.getId().toString(),
                listing.getImage(),
                listing.getTitle(),
                listing.getDescription(),
                listing.getDate(),
                listing.getPrice(),
                listing.getStatus(),
                listing.getReview(),
                listing.getHosterId()
        );
    }

    private List<ListingResponseDTO> convertListingsToResponseDTOs(List<Listing> listings) {
        return listings.stream()
                .map(this::convertListingToResponseDTO)
                .collect(Collectors.toList());
    }
}
