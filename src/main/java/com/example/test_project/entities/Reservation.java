package com.example.test_project.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "Reservation")
public class Reservation {

    @Id
    private BigInteger id;
    private String status;
    private String bookingDate;
    private BigInteger hoster_id;
    private BigInteger visitor_id;
    private BigInteger listing_id;

    // Getters and setters

    public Reservation(BigInteger id, String status, String bookingDate, BigInteger hoster_id,
                       BigInteger visitor_id, BigInteger listing_id) {
        this.id = id;
        this.status = status;
        this.bookingDate = bookingDate;
        this.hoster_id = hoster_id;
        this.visitor_id = visitor_id;
        this.listing_id = listing_id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    public BigInteger getHoster_id() {
        return hoster_id;
    }

    public void setHoster_id(BigInteger hoster_id) {
        this.hoster_id = hoster_id;
    }

    public BigInteger getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(BigInteger visitor_id) {
        this.visitor_id = visitor_id;
    }

    public BigInteger getListing_id() {
        return listing_id;
    }

    public void setListing_id(BigInteger listing_id) {
        this.listing_id = listing_id;
    }
}
