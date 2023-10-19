package com.example.springatelier.Repositories;

import com.example.springatelier.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntrepriseRepo extends JpaRepository<Entreprise, Integer> {

    List<Entreprise> findByLocalisationContainingIgnoreCase(String l);

    @Query("SELECT e from Entreprise e WHERE " +
            "e.nomEntreprise LIKE CONCAT('%',:query, '%')"+
            "Or e.emailEntreprise LIKE CONCAT('%',:query, '%')")
    List<Entreprise> rechercheParNomOuMail(String query);

    List<Entreprise> findByRecruitingTrue();
}
