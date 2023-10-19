package com.example.springatelier.Controlleurs;


import com.example.springatelier.entities.Contrat;
import com.example.springatelier.service.ContratService;
import com.example.springatelier.service.IContratService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Tag(name="Contrat")
@AllArgsConstructor
@RequestMapping("Contrat")
public class ContratController {

    IContratService iContratService;

    @PostMapping("/contrat")
    Contrat addContrat(@RequestBody Contrat C){
      return   iContratService.addContrat(C);
    }
    @PutMapping("/contrat")
    Contrat updateContrat(@RequestBody Contrat C){
        return iContratService.updateContrat(C);
    }
     @GetMapping("/contrat")
     List<Contrat> retrieveAllContrat(){
        return iContratService.retrieveAllContrat();
     }

     @GetMapping("/contrat/{idContact}")
     Contrat retrieveContrat(@PathVariable Integer idContact)
     {
         return iContratService.retrieveContrat(idContact);
     }
      @DeleteMapping("/contrat/{idContact}")
      void deleteContrat(@PathVariable Integer idContact)
      {
          iContratService.deleteContrat(idContact);
      }
    @GetMapping("/getChiffreAffaireEntreDeuxDate")
    public float getChiffreAffaireEntreDeuxDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){
        return iContratService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }
    @GetMapping("/exportContratPDF")
    public void exportPDF( HttpServletResponse response ){
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "contrat "+currentDateTime +".pdf";
        response.setHeader(headerKey, headerValue);

        try {
            iContratService.generatePDF(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/assignToEtudiant")
    public Contrat affectContratToEtudiant (@RequestBody Contrat contrat,@RequestParam String nom ,@RequestParam String prenom){
        return iContratService.affectContratToEtudiant(contrat,nom,prenom);
    }
//    @GetMapping ("/nbContratsValides/{startDate}/{endDate}")
//    Integer nbContratsValides(@PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){
//        return contratService.nbContratsValides(startDate,endDate);
//    }


}
