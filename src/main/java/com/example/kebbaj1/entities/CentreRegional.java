package com.example.kebbaj1.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class CentreRegional extends CentrePostale{


    @OneToMany(mappedBy = "centreRegional", fetch=FetchType.LAZY)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "centrePostaleId")
   // @OneToMany(mappedBy = "centreRegional", fetch=FetchType.EAGER)
    private List<CentrePostale> centrePostales;



    // constructors




    public CentreRegional(String nom, int numero, String rue, String ville, String quartier) {
        super(nom, numero, rue, ville, quartier);
    }


    public CentreRegional() {

    }



    // getters and setters :


    public List<CentrePostale> getCentrePostales() {
        return centrePostales;
    }

    public void setCentrePostales(List<CentrePostale> centrePostales) {
        this.centrePostales = centrePostales;
    }
}
