package com.example.test_project.entities;


public class Insurance {
    private String code;
    private String date;
    private String societe;

    public Insurance() {
    }

    public Insurance(String code, String date, String societe) {
        this.code = code;
        this.date = date;
        this.societe = societe;
    }

    // Getters and setters for Insurance fields

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }
}