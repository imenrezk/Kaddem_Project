package com.example.springatelier.Controlleurs;

import com.example.springatelier.entities.Entreprise;
import com.example.springatelier.service.EntrepriseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Entreprise")
@Tag(name="Entreprise")
public class EntrepriseController {

    EntrepriseService entrepriseService;

    @GetMapping("e")
    List<Entreprise> retrieveAllEnt(){
        return entrepriseService.retrieveAllEnt();
    }

    @PostMapping("e")
    Entreprise addEnt(@RequestBody Entreprise c){
        return entrepriseService.addEnt(c);
    }

    @DeleteMapping("e/{id}")
    void deleteEnt(@PathVariable Integer id){
        entrepriseService.deleteEnt(id);
    }

    @PutMapping("/e/{id}")
    Entreprise updateEnt(@PathVariable Integer id, @RequestBody Entreprise e){
        return entrepriseService.updateEnt(id,e);
    }

    @GetMapping("e/{id}")
    Entreprise retrieveEnt(@PathVariable Integer id){
        return entrepriseService.retrieveEnt(id);
    }

    @GetMapping("searchEntByLocation")
    List<Entreprise> searchEntByLocation( @RequestParam("l") String l){
        return entrepriseService.searchEntByLocation(l);
    }

    @GetMapping("searchEntByNameOrLocation")
    List<Entreprise> searchEntByNameOrLocation( @RequestParam("query") String query){
        return entrepriseService.searchEntByNameOrLocation(query);
    }

    @PutMapping("checkRecruitingDate")
    void checkRecruitingDate(@RequestParam("id") Integer id){
        entrepriseService.checkRecruitingDate(id);
    }

    @GetMapping("logEntrepriseOpenToRecruiting")
    public void logEntrepriseOpenToRecruiting(){
        entrepriseService.logEntrepriseOpenToRecruiting();
    }
}
