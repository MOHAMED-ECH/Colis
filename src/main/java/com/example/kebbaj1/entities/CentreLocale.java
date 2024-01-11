package com.example.kebbaj1.entities;


import jakarta.persistence.Entity;

@Entity
public class CentreLocale extends CentrePostale {


    public CentreLocale(String nom, int numero, String rue, String ville, String quartier) {
        super(nom, numero, rue, ville, quartier);
    }


    public CentreLocale() {

    }
}
