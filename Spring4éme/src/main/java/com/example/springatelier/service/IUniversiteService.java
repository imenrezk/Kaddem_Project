package com.example.springatelier.service;


import com.example.springatelier.entities.Departement;
import com.example.springatelier.entities.Etudiant;
import com.example.springatelier.entities.Universite;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUniversiteService {


    List<Universite> retrieveAllUniversite();

    Universite addUniversite(Universite U);

    void deleteUniversite(Integer idUniv);

    Universite updateUniversite(Universite U);

    Universite retrieveUniversite(Integer idUniv);

     void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

    public List<Universite> triUniversite ();
    public  List<Universite> UnivparDiplome(String diplomes );
    public int nbrDepartementInUniv(Integer idUniv );
   // public int nbrEtudiantInUniv ( Integer idUniv );
    List<Universite>retrieveUniversiteBynom(String nomUniv);
     int nbretudiant(Integer idUniv);

}
