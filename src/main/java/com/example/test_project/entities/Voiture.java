package com.example.test_project.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
@Data
public class Voiture {

    @Id
    private BigInteger id;
    private String immatricule;
    private String marque;
    private String modèle;
    private double prix;
    private String category;
    private int nb_personnes;
    private String carburant;
    private String img;
    private double consommation;
    private Insurance assurance;

    public Voiture() {
    }

    public Voiture(BigInteger id, String immatricule, String marque, String modèle, double prix, String type, int nb_personnes, String carburant, String img, double consommation, Insurance assurance) {
        this.id = id;
        this.immatricule = immatricule;
        this.marque = marque;
        this.modèle = modèle;
        this.prix = prix;
        this.category = type;
        this.nb_personnes = nb_personnes;
        this.carburant = carburant;
        this.img = img;
        this.consommation = consommation;
        this.assurance = assurance;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModèle() {
        return modèle;
    }

    public void setModèle(String modèle) {
        this.modèle = modèle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType() {
        return category;
    }

    public void setType(String type) {
        this.category = type;
    }

    public int getNb_personnes() {
        return nb_personnes;
    }

    public void setNb_personnes(int nb_personnes) {
        this.nb_personnes = nb_personnes;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getConsommation() {
        return consommation;
    }

    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }

    public Insurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Insurance assurance) {
        this.assurance = assurance;
    }
}