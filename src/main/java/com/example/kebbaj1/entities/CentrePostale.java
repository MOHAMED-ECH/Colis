package com.example.kebbaj1.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;


@Entity

@Inheritance(strategy= InheritanceType.JOINED)

public class CentrePostale {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long centrePostaleId;
    private String nom;
    private int numero;
    private String rue;
    private String ville;
    private String quartier;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "centreRegional_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "centrePostaleId")
    private CentreRegional centreRegional;




    @ManyToMany(mappedBy="centrePostales", fetch = FetchType.EAGER)
    private List<Colis> colis;


    @OneToMany(mappedBy = "centrePostale", fetch = FetchType.EAGER)
    private List<Habitant> habitants;

    @OneToMany(mappedBy = "centrePostale", fetch = FetchType.EAGER)
    private List<Facteur> facteurs ;










//getters and setters and constructors


    public Long getCentrePostaleId() {
        return centrePostaleId;
    }

    public void setCentrePostaleId(Long centrePostaleId) {
        this.centrePostaleId = centrePostaleId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public CentreRegional getCentreRegional() {
        return centreRegional;
    }

    public void setCentreRegional(CentreRegional centreRegional) {
        this.centreRegional = centreRegional;
    }

    public List<Colis> getColis() {
        return colis;
    }

    public void setColis(List<Colis> colis) {
        this.colis = colis;
    }

    public List<Habitant> getHabitants() {
        return habitants;
    }

    public void setHabitants(List<Habitant> habitants) {
        this.habitants = habitants;
    }

    public List<Facteur> getFacteurs() {
        return facteurs;
    }

    public void setFacteurs(List<Facteur> facteurs) {
        this.facteurs = facteurs;
    }

    //constructors:


    public CentrePostale() {
    }

    public CentrePostale(String nom, int numero, String rue, String ville, String quartier) {
        this.nom = nom;
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.quartier = quartier;
    }


    @Override
    public String toString() {
        return "CentrePostale{" +
                "centrePostaleId=" + centrePostaleId +
                ", nom='" + nom + '\'' +
                ", numero=" + numero +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", quartier='" + quartier + '\'' +
                '}';
    }
}
