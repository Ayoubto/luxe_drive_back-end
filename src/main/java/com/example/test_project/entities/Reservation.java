package com.example.test_project.entities;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;



@Getter
@Setter
@Document(collection = "reservations")
@Data
public class Reservation {

    @Id
    private BigInteger id;

    private String dateDebut;
    private String dateFin;


    private String agence_depart_id;

    private String agence_retour_id;


    private String voiture_id;


    private String user_id;

    private String status;
    private String reservation;

    // Constructeurs, getters, setters

    public Reservation() {
    }

    public Reservation(String dateDebut, String dateFin, String agenceDepart, String agenceRetour, String voiture, String user, String status, String reservation) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.agence_depart_id = agenceDepart;
        this.agence_retour_id = agenceRetour;
        this.voiture_id = voiture;
        this.user_id = user;
        this.status = status;
        this.reservation = reservation;
    }

    // Getters and setters for other fields


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getAgence_depart_id() {
        return agence_depart_id;
    }

    public void setAgence_depart_id(String agence_depart_id) {
        this.agence_depart_id = agence_depart_id;
    }

    public String getAgence_retour_id() {
        return agence_retour_id;
    }

    public void setAgence_retour_id(String agence_retour_id) {
        this.agence_retour_id = agence_retour_id;
    }

    public String getVoiture_id() {
        return voiture_id;
    }

    public void setVoiture_id(String voiture_id) {
        this.voiture_id = voiture_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }
}

