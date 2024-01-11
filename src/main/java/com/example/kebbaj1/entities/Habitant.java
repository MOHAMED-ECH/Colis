package com.example.kebbaj1.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity

public class Habitant extends Personne {

    private String email;

    private String telephone;


    @ManyToOne
    @JoinColumn(name = "centrePostal_id", nullable = false)
    private CentrePostale centrePostale;


    @OneToMany(mappedBy = "emetteur")
    private List<Colis> colisEmetteur;


    @OneToMany(mappedBy = "destinataire")

    private List<Colis> colisDestinataire;




    //getters and setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public CentrePostale getCentrePostale() {
        return centrePostale;
    }

    public void setCentrePostale(CentrePostale centrePostale) {
        this.centrePostale = centrePostale;
    }

    public List<Colis> getColisEmetteur() {
        return colisEmetteur;
    }

    public void setColisEmetteur(List<Colis> colisEmetteur) {
        this.colisEmetteur = colisEmetteur;
    }

    public List<Colis> getColisDestinataire() {
        return colisDestinataire;
    }

    public void setColisDestinataire(List<Colis> colisDestinataire) {
        this.colisDestinataire = colisDestinataire;
    }



    // constructors :


    public Habitant() {
    }

    public Habitant( String nom, String prenom, String rue, String quartier, String ville, String email, String telephone) {
        super( nom, prenom, rue, quartier, ville);
        this.email = email;
        this.telephone = telephone;
    }



}
