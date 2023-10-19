package com.example.springatelier.service;

import com.example.springatelier.entities.Contrat;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrat();

    Contrat addContrat(Contrat C);

    void deleteContrat(Integer idContact);

    Contrat updateContrat(Contrat C);

    Contrat retrieveContrat(Integer idContact);
  //  Integer nbContratsValides(Date startDate, Date endDate);
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    int  calculerMontant(Contrat contrat);
    void generatePDF(HttpServletResponse response) throws IOException;

    Contrat affectContratToEtudiant(Contrat contrat, String nom, String prenom);
   // Integer nbContratsValides(Date startDate, Date endDate);
}
