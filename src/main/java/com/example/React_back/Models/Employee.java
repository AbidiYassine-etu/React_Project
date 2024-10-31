package com.example.React_back.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee" )
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;

    @Column(unique = true)
    private String email;

    private String password;

    private String adresse;

    private String department;

    private String role;

    @OneToMany
    @JoinColumn(name = "conges")
    private List<Conges> congesList;

    @OneToMany
    @JoinColumn(name = "evaluation")
    private List<Evaluation> evaluationList;

    @OneToOne
    @JoinColumn(name = "feuille_temps")
    private  Feuille_Temps feuilleTemps;
}
