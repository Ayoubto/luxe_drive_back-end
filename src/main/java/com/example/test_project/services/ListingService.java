package com.example.test_project.services;

import com.example.test_project.entities.Listing;

import java.math.BigInteger;
import java.util.List;

public interface ListingService {
    List<Listing> getAllListings();

    Listing getListingById(BigInteger id);

    void saveListing(Listing listing);

    void deleteListing(BigInteger id);

    void updateListing(BigInteger id);
}
