package com.example.kebbaj1.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity

public class Colis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colisId;
    private Long Numero;
    private Date dateDepot;
    private Date dateReception;



    @ManyToOne
    private Facteur facteur;



    @ManyToOne
    @JoinColumn(name="emmeteur_id", nullable = false)
    private Habitant emetteur;


    @ManyToOne
    @JoinColumn(name="destinataire_id", nullable = false)
    private Habitant destinataire;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "centrePostal_colis",
            joinColumns = @JoinColumn(name = "colis"),
            inverseJoinColumns = @JoinColumn(name = "centrePostale"))
    private List<CentrePostale> centrePostales;




    // getters and setters :


    public Long getColisId() {
        return colisId;
    }

    public void setColisId(Long colisId) {
        this.colisId = colisId;
    }

    public Long getNumero() {
        return Numero;
    }

    public void setNumero(Long numero) {
        Numero = numero;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Facteur getFacteur() {
        return facteur;
    }

    public void setFacteur(Facteur facteur) {
        this.facteur = facteur;
    }

    public Habitant getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Habitant emetteur) {
        this.emetteur = emetteur;
    }

    public Habitant getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Habitant destinataire) {
        this.destinataire = destinataire;
    }

    public List<CentrePostale> getCentrePostales() {
        return centrePostales;
    }

    public void setCentrePostales(List<CentrePostale> centrePostales) {
        this.centrePostales = centrePostales;
    }



    //constructors :


    public Colis() {
    }


    public Colis(Long numero, Date dateDepot, Date dateReception) {
        Numero = numero;
        this.dateDepot = dateDepot;
        this.dateReception = dateReception;
    }
}
