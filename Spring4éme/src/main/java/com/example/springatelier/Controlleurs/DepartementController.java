package com.example.springatelier.Controlleurs;


import com.example.springatelier.entities.Departement;
import com.example.springatelier.entities.Option;
import com.example.springatelier.entities.Specialite;
import com.example.springatelier.service.IDepartementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Departementt")
@Tag(name="Departementt")
public class DepartementController {

    IDepartementService iDepartementService;

    @GetMapping("/departement")
    List<Departement> retrieveAllDepartement(){
      return   iDepartementService.retrieveAllDepartement();
    }
    @PostMapping("/departement")
    Departement addDepartement(@RequestBody Departement D){
        return iDepartementService.addDepartement(D);
    }

    @DeleteMapping("departement/{idDepart}")
    void deleteDepartement(@PathVariable Integer idDepart){
        iDepartementService.deleteDepartement(idDepart);
    }

    @PutMapping("/departement")
    Departement updateDepartement(@RequestBody  Departement D){
        return iDepartementService.updateDepartement(D);
    }
    @GetMapping("/departement/{idDepart}")
    Departement retrieveDepartement(@PathVariable Integer idDepart){
        return iDepartementService.retrieveDepartement(idDepart);
    }

    @PostMapping ("/assignEtudiantToDepartement/{etudiantId}/{departementId}")
    void assignEtudiantToDepartement (@PathVariable(value = "etudiantId") Integer etudiantId, @PathVariable(value = "departementId") Integer departementId){
        iDepartementService.assignEtudiantToDepartement(etudiantId,departementId);
       //return "etudiant assigned to departement" ;
    }

    @GetMapping("/retrieveDepartementByoptionn/{option}")
    List<Departement> retrieveDepartementByoption( @PathVariable Option option){
        return iDepartementService.retrieveDepartementByoption(option);
    }
    @GetMapping("/retrieveDepartementByspecialitedecontratt/{specialite}")
    List<Departement> retrieveDepartementByspecialitedecontrat( @PathVariable Specialite specialite ){
        return iDepartementService.retrieveDepartementByspecialitedecontrat(specialite);
    }

    @GetMapping("/NbrEmployeDepartement/{nomDepartement}")
    int NbrEmployeDepartement(@PathVariable  String nomDepartement){
        return iDepartementService.NbrEmployeDepartement(nomDepartement) ;}

    @GetMapping("/tridepartement")
    List<Departement> tridepartement(){
        return iDepartementService.tridepartement();
    }

    @GetMapping("/departementetudiant/{nomE}/{idEtudiant}")
    List<Departement> departementetudiant (@PathVariable String nomE , @PathVariable Integer idEtudiant )
    { return iDepartementService.departementetudiant(nomE,idEtudiant);}
}
