package com.example.test_project.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigInteger;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponseDTO {

    private String id;
    private String status;
    private String bookingDate;
    private String hoster_id;
    private String visitor_id;
    private String listing_id;

    // Getters and setters

    public ReservationResponseDTO(String id, String status, String bookingDate, String hoster_id,
                                  String visitor_id, String listing_id) {
        this.id = id;
        this.status = status;
        this.bookingDate = bookingDate;
        this.hoster_id = hoster_id;
        this.visitor_id = visitor_id;
        this.listing_id = listing_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getHoster_id() {
        return hoster_id;
    }

    public void setHoster_id(String hoster_id) {
        this.hoster_id = hoster_id;
    }

    public String getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(String visitor_id) {
        this.visitor_id = visitor_id;
    }

    public String getListing_id() {
        return listing_id;
    }

    public void setListing_id(String listing_id) {
        this.listing_id = listing_id;
    }
}
