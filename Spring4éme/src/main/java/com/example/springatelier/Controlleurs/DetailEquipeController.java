package com.example.springatelier.Controlleurs;


import com.example.springatelier.entities.DetailEquipe;
import com.example.springatelier.service.IDetailEquipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("DetailEquipe")
@Tag(name="DetailEquipe")
public class DetailEquipeController {

    IDetailEquipeService iDetailEquipeService;

    @GetMapping("/afficherDEQ")
    List<DetailEquipe> retrieveAllDEquipeService()

    {
        return iDetailEquipeService.retrieveAllDEquipeService();
    }
    @PostMapping("/ajouterDEQ")
    DetailEquipe addDetailEquipe(DetailEquipe DE)
    {
        return iDetailEquipeService.addDetailEquipe(DE);
    }
    @DeleteMapping("/supprimerDEQ/{idDetailEquipe}")
    void deleteDetailEquipe(Integer idDetailEquipe)
    {
        iDetailEquipeService.deleteDetailEquipe(idDetailEquipe);
    }
    @PutMapping("/modifierDEQ")
    DetailEquipe updateDetailEquipe(DetailEquipe DE)
    {
        return iDetailEquipeService.updateDetailEquipe(DE);
    }
    @GetMapping("/afficherDEQ/{idDetailEquipe}")
        DetailEquipe retrieveDetailEquipe (Integer idDetailEquipe){
           return iDetailEquipeService.retrieveDetailEquipe(idDetailEquipe);
    }
}
