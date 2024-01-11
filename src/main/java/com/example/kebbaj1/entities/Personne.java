package com.example.kebbaj1.entities;


import jakarta.persistence.*;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long personneId;

    private String nom;

    private String prenom;

    private String rue;
    private String quartier;

    private String ville;



    //getters and setters


    public Long getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Long personneId) {
        this.personneId = personneId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }




    // constructors


    public Personne() {
    }


    public Personne( String nom, String prenom, String rue, String quartier, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.quartier = quartier;
        this.ville = ville;
    }
}
