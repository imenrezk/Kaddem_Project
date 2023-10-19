package com.example.springatelier.service;


import com.example.springatelier.Repositories.ContratRepository;
import com.example.springatelier.Repositories.EquipeRepository;
import com.example.springatelier.Repositories.EtudiantRepository;
import com.example.springatelier.entities.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EtudiantService implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiant(){
        return  etudiantRepository.findAll();
    }
    @Override

    public   Etudiant addEtudiant(Etudiant Et){
        return etudiantRepository.save(Et);
    }
    @Override
    public  void deleteEtudiant(Integer idEtudiant){
        etudiantRepository.deleteById(idEtudiant);
    }
    @Override
    public  Etudiant updateEtudiant(Etudiant Et){
        return etudiantRepository.save(Et);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant){
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }
//    @Override
//     public
//    addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
//        Etudiant ee= etudiantRepository.save(e);
//        Contrat cc = contratRepository.findById(idContrat).get();
//        Equipe eq = equipeRepository.findById(idEquipe).get();
//        cc.setEtudiant(ee);
//        eq.getEtudiants().add(e);
//        return etudiantRepository.save(e);
//     //return ee.getEquipes().add(eq)  && ee.setContrats().add(cc) ;
//    }

    @Override
    public   List<Etudiant> getEtudiantsByDepartement (Integer idDepart){
  // return etudiantRepository.getEtudiantsByDepartement(idDepart);
        return etudiantRepository.findByDepartementIdDepart(idDepart);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
        Equipe eq =  equipeRepository.findById(idEquipe).orElse(null);
        Contrat c = contratRepository.findById(idContrat).orElse(null);
        c.setEtudiant(e);
        eq.getEtudiants().add(e);
        return etudiantRepository.save(e);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e= etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        if (contratRepository.countContratsByEtudiant(e)<5) {
            e.getContrats().add(ce);
            return ce;
        }
        return null;
    }
    @Override
      public  List<Etudiant> retrieveEtudiantBythematiquee(String thematique){
         return etudiantRepository.retrieveEtudiantBythematique(thematique);
    }

    @Override
    public List<Etudiant> retrieveEntreprisesBySpecialiteEquipee( Specialite specialite){
        return etudiantRepository.retrieveEntreprisesBySpecialiteEquipe(specialite);
    }
    @Override
    public List<Etudiant> retrieveEtudiantByoptionn( Option option){
        return etudiantRepository.findByOption(option);
    }

    @Override
    public   int NBREtudiantDepartement(Integer idDepart){
        return etudiantRepository.nbrEtudiantDepartement(idDepart);
    }
    @Scheduled(cron ="5 4 * * *")
    @Override
    public   List<Etudiant> TRIEtudiant(){
        log.info("tri avec nom");
        return etudiantRepository.triEtudiant();
    }
    @Override
   public List<Etudiant> retrieveEtudiantByarchiveEquipee (boolean archive){
        return etudiantRepository.retrieveEtudiantByarchiveEquipe(archive);
    }
//    @Override
//    public  List<Etudiant> retrieveEtudiantByMontantcontratt (Integer montantContrat){
//        return etudiantRepository.retrieveEtudiantByMontantcontrat(montantContrat);
//    }
    @Override
    public void deleteEtudiantOptionn(){
         etudiantRepository.deleteEtudiantOption();
    }

}
