package com.example.springatelier.service;

import com.example.springatelier.Repositories.EntrepriseRepo;
import com.example.springatelier.Repositories.EquipeRepository;
import com.example.springatelier.entities.Entreprise;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class EntrepriseServiceimpl implements EntrepriseService{
    EntrepriseRepo entrepriseRepo;
    EquipeRepository equipeRepo;

    @Override
    public List<Entreprise> retrieveAllEnt(){
        return entrepriseRepo.findAll();
    }

    @Override
    public Entreprise addEnt(Entreprise c){
        return entrepriseRepo.save(c);
    }

    @Override
    public void deleteEnt(Integer id){
        entrepriseRepo.deleteById(id);
    }

    @Override
    public Entreprise updateEnt(Integer id,  Entreprise e){
        Entreprise ent = entrepriseRepo.findById(id).orElse(null);

        ent.setNomEntreprise(e.getNomEntreprise());
        ent.setLocalisation(e.getLocalisation());

        return entrepriseRepo.save(ent);
    }

    @Override
    public Entreprise retrieveEnt(Integer id){
        return entrepriseRepo.findById(id).orElse(null);
    }

    @Override
    public List<Entreprise> searchEntByLocation(String l){
        return entrepriseRepo.findByLocalisationContainingIgnoreCase(l);
    };

    @Override
    public List<Entreprise> searchEntByNameOrLocation(String query){
        return entrepriseRepo.rechercheParNomOuMail(query);
    }

    @Override
    public void checkRecruitingDate(Integer id){
        LocalDateTime localDateTime = LocalDateTime.now();
        Entreprise e = entrepriseRepo.findById(id).orElse(null);

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        //Date a=e.getDateDFinAlternance();
        //System.out.println(date.after(e.getDateDebutAlternance()) && date.before(e.getDateDFinAlternance()));
        if(date.after(e.getDateDebutAlternance()) && date.before(e.getDateDFinAlternance()) ){
            e.setRecruiting(true);
            //e.setEmailEntreprise("haha");

        }
        entrepriseRepo.save(e);
    };

    @Override
    @Scheduled(cron ="5 4 * * *")
    public void logEntrepriseOpenToRecruiting(){

        List<Entreprise> a = entrepriseRepo.findByRecruitingTrue();
        //System.out.println(a);
        log.info(a.toString());
    };
}
