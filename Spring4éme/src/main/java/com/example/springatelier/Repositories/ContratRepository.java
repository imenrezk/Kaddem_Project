package com.example.springatelier.Repositories;

import com.example.springatelier.entities.Contrat;
import com.example.springatelier.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat,Integer> {

    Integer countContratsByEtudiant(Etudiant e);


   // List<Contrat>findContratByDateFinContratBetween (Date date1,Date date2);
    //List<Contrat> findByDateDebutLessThanEqualAndDateFinGreaterThanEqual(Date endDate, Date startDate);
    List<Contrat> findByDateDebutConratLessThanEqualAndDateFinConratGreaterThanEqual(Date endDate, Date startDate);

}
