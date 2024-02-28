package com.example.test_project.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "Listing")
public class Listing {

    @Id
    private BigInteger id;
    private String image;
    private String title;
    private String description;
    private String date;
    private double price;
    private String status;
    private String review;
    private String hosterId;

    public Listing() {
    }

    public Listing(BigInteger id, String image, String title, String description, String date, double price,
                   String status, String review, String hosterId) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.date = date;
        this.price = price;
        this.status = status;
        this.review = review;
        this.hosterId = hosterId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getHosterId() {
        return hosterId;
    }

    public void setHosterId(String hosterId) {
        this.hosterId = hosterId;
    }
}
