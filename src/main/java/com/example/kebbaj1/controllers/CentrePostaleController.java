package com.example.kebbaj1.controllers;

import com.example.kebbaj1.entities.CentrePostale;
import com.example.kebbaj1.entities.CentrePostale;
import com.example.kebbaj1.entities.CentreRegional;
import com.example.kebbaj1.repositories.CentrePostalRepo;
import com.example.kebbaj1.repositories.CentreRegionalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api")
public class CentrePostaleController {

    @Autowired

    CentrePostalRepo centrePostaleRepo;

    @Autowired
    CentreRegionalRepo centreRegionalRepo;
    @GetMapping("/centrePostaux")
    public List<CentrePostale> getCentrePostaux(){
        return centrePostaleRepo.findAll();
    }


    @GetMapping("/centrePostale/{id}")

    public CentrePostale getCentrePostale(@PathVariable Long id){
        return centrePostaleRepo.findById(id).get();
    }


    @PostMapping("/centrePostale/{idecntreRegional}")
    public ResponseEntity<CentrePostale> addcentrePostale(@RequestBody CentrePostale centrePostale, @PathVariable Long idCentreRegional) {
        Optional<CentreRegional> centreRegionalOptional = centreRegionalRepo.findById(idCentreRegional);

        if (centreRegionalOptional.isPresent()) {
            CentreRegional centreRegional = centreRegionalOptional.get();
            centrePostale.setCentreRegional(centreRegional);
            CentrePostale savedcentrePostale = centrePostaleRepo.save(centrePostale);
            return ResponseEntity.ok(savedcentrePostale);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PutMapping("/centrePostale/{id}")
    public ResponseEntity<CentrePostale> updatecentrePostale(@RequestBody CentrePostale centrePostale, @PathVariable Long id) {
        Optional<CentrePostale> Optional = centrePostaleRepo.findById(id);

if (Optional.isPresent()) {
            CentrePostale centrePostale1 = Optional.get();
            centrePostale1.setNom(centrePostale.getNom());
            centrePostale1.setNumero(centrePostale.getNumero());
            centrePostale1.setRue(centrePostale.getRue());
            centrePostale1.setVille(centrePostale.getVille());
            centrePostale1.setCentreRegional(centrePostale.getCentreRegional());
            CentrePostale savedcentrePostale = centrePostaleRepo.save(centrePostale1);
            return ResponseEntity.ok(savedcentrePostale);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @DeleteMapping("/centrePostale/{id}")
    public void deletecentrePostale(@PathVariable Long id){

       CentrePostale centrePostale = centreRegionalRepo.findById(id).get();

      CentreRegional centreR=  centreRegionalRepo.findById(centrePostale.getCentreRegional().getCentrePostaleId()).get();

        centrePostaleRepo.deleteById(id);

        centreR.getCentrePostales().remove(centrePostale);

        System.out.println("centre locale deleted");
    }


}
