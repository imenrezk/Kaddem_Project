package com.example.springatelier.Controlleurs;


import com.example.springatelier.entities.Departement;
import com.example.springatelier.entities.Universite;
import com.example.springatelier.service.IUniversiteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name="Universite")
@RequestMapping("Universite")
public class UniversiteController {

    IUniversiteService iUniversiteService;

    @GetMapping("/universite")
    List<Universite> retrieveAllUniversite(){
        return iUniversiteService.retrieveAllUniversite();
    }
    @PostMapping("/universite")
    Universite addUniversite(@RequestBody Universite U){
        return iUniversiteService.addUniversite(U);
    }
@DeleteMapping("/universite/{idUniv}")
    void deleteUniversite(@PathVariable Integer idUniv){
        iUniversiteService.deleteUniversite(idUniv);
}
    @PutMapping("/universite")
    Universite updateUniversite(@RequestBody Universite U){
    return iUniversiteService.updateUniversite(U);
    }
    @GetMapping("/universite/{idUniv}")
    Universite retrieveUniversite(@PathVariable Integer idUniv){
        return iUniversiteService.retrieveUniversite(idUniv);
    }
     @GetMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
     String assignUniversiteToDepartement(@PathVariable(value = "idUniversite") Integer idUniversite,  @PathVariable(value = "idDepartement") Integer idDepartement){
        iUniversiteService.assignUniversiteToDepartement(idUniversite,idDepartement);
        return "universite assigned to departement";
     }

    @GetMapping("/retrievedeptbyuniv/{idUniversite}")
    List<Departement> retrieveDepartementsByUniversite(@PathVariable Integer idUniversite){
        return iUniversiteService.retrieveDepartementsByUniversite(idUniversite);
    }

    @GetMapping("/triUni")
    List<Universite> triUnivParDepartementt(){
        return iUniversiteService.triUniversite();
    }

    @GetMapping("/UnivParDiplomee/{diplomes}")
    public  List<Universite> UnivparDiplome( String diplomes ){
        return iUniversiteService.UnivparDiplome(diplomes);
    }
    @GetMapping("/depParUniv/{id}")
    public int nbrDepartementInUniv(@PathVariable ("id") Integer id){
        return iUniversiteService.nbrDepartementInUniv(id);
    }
    @GetMapping("depEtudUniv/{idUniv}")
    public int nbretudiant(Integer idUniv){
        return iUniversiteService.nbretudiant(idUniv);
    }
    @GetMapping("/retrieveUniversiteBynom/{nomUniv}")
    public   List<Universite>retrieveUniversiteBynom(String nomUniv){
        return iUniversiteService.retrieveUniversiteBynom(nomUniv);
    }


}
