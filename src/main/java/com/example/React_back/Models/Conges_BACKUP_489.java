package com.example.React_back.Models;

<<<<<<< HEAD
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
@Table(name="congés")
public class Conges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date_Debut;
    private String date_Fin;
    private int nbr_jour_Restant;
    private boolean payant;

    @ManyToOne
    @JoinColumn(name = "employée_id")
    private Employée employee;

    @ManyToOne
    @JoinColumn(name = "rh_id")
    private Admin_RH adminRH;
=======

public class Conges {
>>>>>>> 208c9823adbb0dc0c359ce0cca053b9665167300
}
