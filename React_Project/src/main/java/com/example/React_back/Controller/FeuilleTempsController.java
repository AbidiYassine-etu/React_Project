package com.example.React_back.Controller;

import com.example.React_back.Models.Feuille_Temps;
import com.example.React_back.Services.FeuilleTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feuille-temps")  
public class FeuilleTempsController {

    @Autowired
    private FeuilleTempsService feuilleTempsService;

    @GetMapping
    public List<Feuille_Temps> getAllFeuilles() {
        return feuilleTempsService.findAllFeuilles(); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feuille_Temps> getFeuilleById(@PathVariable int id) {
        Feuille_Temps feuille = feuilleTempsService.findFeuilleByID(id);
        if (feuille != null) {
            return new ResponseEntity<>(feuille, HttpStatus.OK);  
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
        }
    }

    @PostMapping
    public ResponseEntity<Feuille_Temps> createFeuille(@RequestBody Feuille_Temps feuille) {
        Feuille_Temps createdFeuille = feuilleTempsService.addFeuille(feuille);
        return new ResponseEntity<>(createdFeuille, HttpStatus.CREATED);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feuille_Temps> updateFeuille(@PathVariable int id, @RequestBody Feuille_Temps feuille) {
        feuille.setId(id);  
        Feuille_Temps updatedFeuille = feuilleTempsService.updateFeuille(feuille);
        if (updatedFeuille != null) {
            return new ResponseEntity<>(updatedFeuille, HttpStatus.OK);  
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeuille(@PathVariable int id) {
        feuilleTempsService.deleteFeuille(id);  
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
    }

    
     @PutMapping("/approuver/{id}")
    public ResponseEntity<Feuille_Temps> approuverFeuille(@PathVariable int id) {
         Feuille_Temps feuille = feuilleTempsService.approuverFeuille(id);
    if (feuille != null) {
        return new ResponseEntity<>(feuille, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


      @PutMapping("/rejeter/{id}")
    public ResponseEntity<Feuille_Temps> rejeterFeuille(@PathVariable int id) {
         Feuille_Temps feuille = feuilleTempsService.rejeterFeuille(id);
    if (feuille != null) {
        return new ResponseEntity<>(feuille, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

}


    
