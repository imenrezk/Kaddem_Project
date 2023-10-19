package com.example.springatelier.Controlleurs;

import com.example.springatelier.entities.Equipe;
import com.example.springatelier.service.IEquipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Equipe")
@Tag(name="Equipe")
public class EquipeController {

 IEquipeService iEquipeService;

@GetMapping("/equipe")
    List<Equipe> retrieveAllEquipe(){
    return iEquipeService.retrieveAllEquipe();
}
@PostMapping("/equipe")
    Equipe addEquipe(@RequestBody Equipe E){
    return iEquipeService.addEquipe(E);
}
@DeleteMapping("/equipe/{idEquipe}")
    void deleteCEquipe(@PathVariable Integer idEquipe){
     iEquipeService.deleteEquipe(idEquipe);
}
@PutMapping("/equipe")
    Equipe updateEquipe(@RequestBody Equipe E){
    return iEquipeService.updateEquipe(E);
}
@GetMapping("/equipe/{idEquipe}")
    Equipe retrieveEquipe(@RequestParam Integer idEquipe) {
    return iEquipeService.retrieveEquipe(idEquipe);
}
}
