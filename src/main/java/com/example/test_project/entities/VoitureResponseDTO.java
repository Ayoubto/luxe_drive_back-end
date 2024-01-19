package com.example.test_project.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigInteger;
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoitureResponseDTO {
    //    @JsonProperty("id")
    private String id;
    private String immatricule;
    private String marque;
    private String modèle;
    private double prix;

    private int nb_personnes;
    private String carburant;
    private String img;
    private double consommation;
    private String status;
    @JsonProperty("assurance")
    private Insurance assurance;
    private String category;

    public VoitureResponseDTO(String id, String immatricule, String marque, String modèle, double prix, int nb_personnes, String carburant, String img, double consommation, String status, Insurance assurance, String category) {
        this.id = id;
        this.immatricule = immatricule;
        this.marque = marque;
        this.modèle = modèle;
        this.prix = prix;
        this.nb_personnes = nb_personnes;
        this.carburant = carburant;
        this.img = img;
        this.consommation = consommation;
        this.status = status;
        this.assurance = assurance;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public String getMarque() {
        return marque;
    }

    public String getModèle() {
        return modèle;
    }

    public double getPrix() {
        return prix;
    }

    public int getNb_personnes() {
        return nb_personnes;
    }

    public String getCarburant() {
        return carburant;
    }

    public String getImg() {
        return img;
    }

    public double getConsommation() {
        return consommation;
    }

    public String getStatus() {
        return status;
    }

    public Insurance getAssurance() {
        return assurance;
    }

    public String getCategory() {
        return category;
    }
}

