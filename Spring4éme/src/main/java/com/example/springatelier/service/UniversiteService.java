package com.example.springatelier.service;


import com.example.springatelier.Repositories.DepartementRepository;
import com.example.springatelier.Repositories.UniversiteRepository;
import com.example.springatelier.entities.Departement;
import com.example.springatelier.entities.Etudiant;
import com.example.springatelier.entities.Universite;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {

    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;

    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite U) {
        return universiteRepository.save(U);
    }

    @Override
    public void deleteUniversite(Integer idUniv) {
        universiteRepository.deleteById(idUniv);
    }
    @Scheduled(cron ="20 * * * *")
    @Override
    public Universite updateUniversite(Universite U) {
        log.info("update universite");
        return universiteRepository.save(U);
    }
    @Override
    public Universite retrieveUniversite(Integer idUniv) {
        return universiteRepository.findById(idUniv).orElse(null);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite uu = universiteRepository.findById(idUniversite).get();
        //  uu.setDepartements(departementRepository.findById(idDepartement));
        Departement dd = departementRepository.findById(idDepartement).get();
        uu.getDepartements().add(dd);
        universiteRepository.save(uu);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite u = universiteRepository.findAllByIdUniv(idUniversite);
        List<Departement> d = new ArrayList<>();
        d.addAll(u.getDepartements());
        return d;
    }

    @Override
    public List<Universite> triUniversite() {
        return universiteRepository.triunversite();
    }

    @Override
    public List<Universite> UnivparDiplome(String diplomes) {
        return universiteRepository.getUniversiteByDiplome(diplomes);
    }

    @Override
    public int nbrDepartementInUniv(Integer idUniv) {
        return universiteRepository.nbrdepUniv(idUniv);
    }

//    @Override
//    public int nbrEtudiantInUniv(Integer idUniv) {
//        return universiteRepository.nbretudUniv(idUniv);
//    }

    @Override
    public List<Universite> retrieveUniversiteBynom(String nomUniv) {
        return universiteRepository.retrieveUniversiteBynom(nomUniv);
    }
    @Override
    public int nbretudiant(Integer idUniv) {
        int somme=0;
        Universite universite = universiteRepository.findById(idUniv).orElse(null);
        Set<Departement> departements = universite.getDepartements();
        for (Departement list : departements) {
       somme += list.getEtudiants().size();
        }
        return somme;
    }
}

