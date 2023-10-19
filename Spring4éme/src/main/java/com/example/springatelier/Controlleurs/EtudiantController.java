package com.example.springatelier.Controlleurs;


import com.example.springatelier.entities.Contrat;
import com.example.springatelier.entities.Etudiant;
import com.example.springatelier.entities.Option;
import com.example.springatelier.entities.Specialite;
import com.example.springatelier.service.IEtudiantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name="Etudiant")
@RequestMapping("Etudiant")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class EtudiantController {
    IEtudiantService iEtudiantService;
    @GetMapping("/etudiant")
    List<Etudiant> retrieveAllEtudiant(){
        return iEtudiantService.retrieveAllEtudiant();
    }
    @PostMapping("/etudiant")
    Etudiant addEtudiant(@RequestBody Etudiant Et){
        return iEtudiantService.addEtudiant(Et);
    }
    @DeleteMapping("/etudiant/{idEtudiant}")
    void deleteEtudiant( @PathVariable Integer idEtudiant){
        iEtudiantService.deleteEtudiant(idEtudiant);
}
     @PutMapping("/etudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant Et){
        return iEtudiantService.updateEtudiant(Et);
     }
    @GetMapping("/etudiant/{idEtudiant}")
    Etudiant retrieveEtudiant(@PathVariable Integer idEtudiant)
    {
        return iEtudiantService.retrieveEtudiant(idEtudiant);
    }
//    @GetMapping  ("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
//    boolean addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable(value = "idContrat") Integer idContrat,@PathVariable(value = "idEquipe") Integer idEquipe) {
//          iEtudiantService.addAndAssignEtudiantToEquipeAndContract( e,  idContrat,  idEquipe);
//        return true;
//    }
@PutMapping ("/addAndAssignEtuToContandEquip/{idContrat}/{idEquipe}")
Etudiant ajouterAndAffecterEtudiantToEquipeAndContract(@RequestBody  Etudiant e,@PathVariable Integer idContrat,@PathVariable Integer idEquipe) {
    return iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat, idEquipe );
}

    @GetMapping("/getetudiantbydepartement/{idDepart}")
    List<Etudiant> getEtudiantsByDepartement (Integer idDepart){
      return iEtudiantService.getEtudiantsByDepartement(idDepart);
    }

    @PutMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    Contrat affectContratToEtudiant (@RequestBody Contrat ce, @PathVariable String nomE, @PathVariable String prenomE){
        return iEtudiantService.affectContratToEtudiant(ce, nomE, prenomE);

    }
    @GetMapping("/retrieveEtudiantBythematique/{thematique}")
    List<Etudiant> retrieveEtudiantBythematiquee (String thematique){
     return iEtudiantService.retrieveEtudiantBythematiquee(thematique);
    }

    @GetMapping("/retrieveEntreprisesBySpecialiteEquipe/{specialite}")
    List<Etudiant> retrieveEntreprisesBySpecialiteEquipee (@PathVariable Specialite specialite){
        return iEtudiantService.retrieveEntreprisesBySpecialiteEquipee(specialite);
    }
    @GetMapping("/retrieveEtudiantByoption/{option}")
       List<Etudiant> retrieveEtudiantByoptionn(@PathVariable Option option){
        return iEtudiantService.retrieveEtudiantByoptionn(option);
    }
    @GetMapping("/nbretudiantpardepartementtt/{idDepart}")
    public int NBREtudiantDepartement(@PathVariable Integer idDepart){
         return iEtudiantService.NBREtudiantDepartement(idDepart);
    }
    @GetMapping("/trietudiant")
    public   List<Etudiant> TRIEtudiant(){
        return iEtudiantService.TRIEtudiant();
    }
    @GetMapping("/retrieveEtudiantByarchiveEquipee/{archive}")
    public List<Etudiant> retrieveEtudiantByarchiveEquipee (boolean archive){
        return iEtudiantService.retrieveEtudiantByarchiveEquipee(archive);
    }
//    @GetMapping("/retrieveEtudiantByMontantcontrat/{montantContrat}")
//    public List<Etudiant> retrieveEtudiantByMontantcontratt (Integer montantContrat){
//        return iEtudiantService.retrieveEtudiantByMontantcontratt(montantContrat);
//    }
@DeleteMapping("/etudiantt")
    public void deleteEtudiantOptionn(){
       iEtudiantService.deleteEtudiantOptionn();
    }
}


