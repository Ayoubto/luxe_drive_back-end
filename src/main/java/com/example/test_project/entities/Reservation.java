package com.example.test_project.entities;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.time.LocalDateTime;


@Getter
@Setter
@Document(collection = "reservations")
//@Document
@Data
public class Reservation {

    @Id
    private BigInteger id;

    @Field("date_debut")
    private LocalDateTime dateDebut;

    @Field("date_fin")
    private LocalDateTime dateFin;



    private BigInteger agence_depart_id;

    private BigInteger agence_retour_id;


    private BigInteger voiture_id;


    private BigInteger user_id;

    private String status;
    private String reservation;



    public Reservation() {
    }

    public Reservation(LocalDateTime date_debut, LocalDateTime date_fin, BigInteger agenceDepart, BigInteger agenceRetour, BigInteger voiture, BigInteger user, String status, String reservation) {
        this.dateDebut = date_debut;
        this.dateFin = date_fin;
        this.agence_depart_id = agenceDepart;
        this.agence_retour_id = agenceRetour;
        this.voiture_id = voiture;
        this.user_id = user;
        this.status = status;
        this.reservation = reservation;
    }




    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime date_debut) {
        this.dateDebut = date_debut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime date_fin) {
        this.dateFin = date_fin;
    }

    public BigInteger getAgence_depart_id() {
        return agence_depart_id;
    }

    public void setAgence_depart_id(BigInteger agence_depart_id) {
        this.agence_depart_id = agence_depart_id;
    }

    public BigInteger getAgence_retour_id() {
        return agence_retour_id;
    }

    public void setAgence_retour_id(BigInteger agence_retour_id) {
        this.agence_retour_id = agence_retour_id;
    }

    public BigInteger getVoiture_id() {
        return voiture_id;
    }

    public void setVoiture_id(BigInteger voiture_id) {
        this.voiture_id = voiture_id;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
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

