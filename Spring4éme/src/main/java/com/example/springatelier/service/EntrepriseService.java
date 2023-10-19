package com.example.springatelier.service;

import com.example.springatelier.entities.Entreprise;

import java.util.List;

public interface EntrepriseService {
    List<Entreprise> retrieveAllEnt();

    Entreprise addEnt(Entreprise e);

    void deleteEnt(Integer id);

    Entreprise updateEnt(Integer id,Entreprise e);

    Entreprise retrieveEnt(Integer id);

    List<Entreprise> searchEntByLocation(String l);

    List<Entreprise> searchEntByNameOrLocation(String l);

    //void assignEquipeToEntreprise (Integer equipeId, Integer entrepriseId);
    void checkRecruitingDate(Integer id);
    void logEntrepriseOpenToRecruiting();

}
