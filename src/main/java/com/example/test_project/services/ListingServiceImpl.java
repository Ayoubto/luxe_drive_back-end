package com.example.test_project.services;

import com.example.test_project.entities.Listing;
import com.example.test_project.reposiroty.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    @Autowired
    public ListingServiceImpl(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Override
    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    @Override
    public Listing getListingById(BigInteger id) {
        return listingRepository.findById(id).orElse(null);
    }

    @Override
    public void saveListing(Listing listing) {
        listingRepository.save(listing);
    }

    @Override
    public void deleteListing(BigInteger id) {
        listingRepository.deleteById(id);
    }

    @Override
    public void updateListing(BigInteger id) {
        // Implementation for updating a listing
    }
}
