package com.example.springatelier.service;

import com.example.springatelier.entities.Contrat;
import com.example.springatelier.entities.Departement;
import com.example.springatelier.entities.Option;
import com.example.springatelier.entities.Specialite;

import java.util.List;

public interface IDepartementService {

    List<Departement> retrieveAllDepartement();

    Departement addDepartement(Departement D);

    void deleteDepartement(Integer idDepart);

    Departement updateDepartement(Departement D);

    Departement retrieveDepartement(Integer idDepart);

     void assignEtudiantToDepartement (Integer etudiantId, Integer departementId);

    List<Departement> retrieveDepartementByoption( Option option);
    List<Departement> retrieveDepartementByspecialitedecontrat( Specialite specialite);

    int NbrEmployeDepartement (String nomDepartement);

    List<Departement> tridepartement();

    List<Departement> departementetudiant (String nomE,Integer idEtudiant);
}
