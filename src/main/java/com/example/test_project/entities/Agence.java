package com.example.test_project.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "agences")
@Data
public class Agence {

    @Id
    private BigInteger id;
    private String nom_agence;
    private String adresse;
    private String telephone_agence;
    private String email_agence;
    private Localisation localisation;

    public Agence() {
    }

    public Agence(BigInteger id, String nom, String adresse, String telephone, String email, Localisation localisation) {
        this.id = id;
        this.nom_agence = nom;
        this.adresse = adresse;
        this.telephone_agence = telephone;
        this.email_agence = email;
        this.localisation = localisation;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNom() {
        return nom_agence;
    }

    public void setNom(String nom) {
        this.nom_agence = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone_agence;
    }

    public void setTelephone(String telephone) {
        this.telephone_agence = telephone;
    }

    public String getEmail() {
        return email_agence;
    }

    public void setEmail(String email) {
        this.email_agence = email;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }
}