package com.example.kebbaj1.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity

public class Facteur extends Personne{



    @OneToMany(mappedBy = "facteur", fetch = FetchType.EAGER)
    private List<Colis> colis;


    @ManyToOne
    @JoinColumn(name = "centrePostale_id")
    private CentrePostale centrePostale;



    //constructors


    public Facteur() {
    }

    public Facteur(String nom, String prenom, String rue, String quartier, String ville) {
        super(nom, prenom, rue, quartier, ville);
    }

    //getters and constructor :


    public List<Colis> getColis() {
        return colis;
    }

    public void setColis(List<Colis> colis) {
        this.colis = colis;
    }

    public CentrePostale getCentrePostale() {
        return centrePostale;
    }

    public void setCentrePostale(CentrePostale centrePostale) {
        this.centrePostale = centrePostale;
    }
}
