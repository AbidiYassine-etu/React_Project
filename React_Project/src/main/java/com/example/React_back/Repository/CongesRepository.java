package com.example.React_back.Repository;

import com.example.React_back.Models.Conges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongesRepository extends JpaRepository<Conges, Integer> {
    List<Conges> findByStatut(String statut);  // Requête pour filtrer les congés par statut
}
