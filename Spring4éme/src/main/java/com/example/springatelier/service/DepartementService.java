package com.example.springatelier.service;


import com.example.springatelier.Repositories.DepartementRepository;
import com.example.springatelier.Repositories.EtudiantRepository;
import com.example.springatelier.entities.Departement;
import com.example.springatelier.entities.Etudiant;
import com.example.springatelier.entities.Option;
import com.example.springatelier.entities.Specialite;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DepartementService implements IDepartementService {

    DepartementRepository departementRepository;
    EtudiantRepository etudiantRepository;
    @Scheduled(cron ="15 * * * *")
    @Override
    public List<Departement> retrieveAllDepartement(){
        log.info("recuperer tous les departements");
        return departementRepository.findAll();
    }

    @Override
    public  Departement addDepartement(Departement D){
        return departementRepository.save(D);
    }

    @Override
    public  void deleteDepartement(Integer idDepart){
        departementRepository.deleteById(idDepart);
    }

    @Override
    public  Departement updateDepartement(Departement D){
        return departementRepository.save(D);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart){
        return departementRepository.findById(idDepart).orElse(null);
    }
    @Override
    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId){
      Etudiant ee= etudiantRepository.findById(etudiantId).get();
      ee.setDepartement(departementRepository.findById(departementId).get());
      etudiantRepository.save(ee);
}
    @Override
    public List<Departement> retrieveDepartementByoption( Option option){
        return departementRepository.retrievedepartementByoption(option);
    }
    @Override
    public List<Departement> retrieveDepartementByspecialitedecontrat( Specialite specialite){
        return departementRepository.retrievedepartementByspecialitedecontrat(specialite);
    }
    @Override
    public int NbrEmployeDepartement (String nomDepartement){
        return departementRepository.nbrEmployeDepartement(nomDepartement);
    }

    @Override
    public List<Departement> tridepartement()
    { return departementRepository.triDepartement();}

    @Override
    public List<Departement> departementetudiant (String nomE, Integer idEtudiant)
    { return departementRepository.departementEtudiant(nomE,idEtudiant);}







}

