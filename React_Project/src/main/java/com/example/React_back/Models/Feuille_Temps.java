package com.example.React_back.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "feuilles")
public class Feuille_Temps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dateFeuille;  
    private String sujetFeuille; 
    private String commentaireFeuille;  

    @ManyToOne
    @JoinColumn(name = "rh_id")
    private Admin_RH adminRH;  

    @ManyToOne
    @JoinColumn(name = "employe_id")  
    private Employe employe;  

    private String statut;
}
