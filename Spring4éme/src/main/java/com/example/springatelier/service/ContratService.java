package com.example.springatelier.service;


import com.example.springatelier.Repositories.ContratRepository;
import com.example.springatelier.Repositories.EtudiantRepository;
import com.example.springatelier.entities.Contrat;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


@Service
@AllArgsConstructor
 public class ContratService implements IContratService {

   ContratRepository contratRepository;
 EtudiantRepository etudiantRepository;

   @Override
    public List<Contrat> retrieveAllContrat(){
       return contratRepository.findAll();
   }

   @Override
    public  Contrat addContrat(Contrat C){
       return contratRepository.save(C);
   }

   @Override
    public void deleteContrat(Integer idContact){
       contratRepository.deleteById(idContact);
   }
   @Override
    public Contrat updateContrat(Contrat C){
       return contratRepository.save(C);
   }
   @Override
    public  Contrat retrieveContrat(Integer idContact){
       return contratRepository.findById(idContact).orElse(null);
   }

//    @Override
//    public Integer nbContratsValides(Date startDate, Date endDate) {
//        int nb=0;
//        List<Contrat>C=contratRepository.findContratByDateFinContratBetween(startDate,endDate);
//        for(int i=0;i<C.size();i++){
//            if(C.get(i).getArchive()==false){
//                nb ++;
//            }
//        }
//        return nb;
//    }



    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findByDateDebutConratLessThanEqualAndDateFinConratGreaterThanEqual(endDate,startDate);

        return (float) contrats.stream().mapToInt(contrat -> {
                    int montant = 0;
                    Date start = contrat.getDateDebutConrat();
                    Date end = contrat.getDateFinConrat();

                    
                    if (contrat.getDateDebutConrat().before(startDate))
                        start = startDate;
                    if (contrat.getDateFinConrat().after((endDate)))
                        end = endDate;
                    int diff = getDiffDateInMonths(start,end);
                    montant = diff * getTarifReglement(contrat);
                    System.out.println("Contrat " + contrat.getIdContact() + ": " + getTarifReglement(contrat) + "*" + diff + "=" + getTarifReglement(contrat) * diff);
                    return montant;
                })
                .reduce(0, (chiffreAffaire, curr) -> chiffreAffaire + curr);

    }
    public int getTarifReglement(Contrat contrat){
        int reglement;
        switch (contrat.getSpecialite()) {
            case IA:
                reglement = 300;
                break;
            case Reseaux:
                reglement = 350;
                break;
            case Cloud:
                reglement = 400;
                break;
            case Securite:
                reglement = 450;
                break;
            default:
                reglement = 0;
        }
        return reglement;
    }

    public int getDiffDateInMonths(Date date1, Date date2){
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(date1);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(date2);
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diff = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        diff ++;
        return diff;
    }
    public int  calculerMontant(Contrat contrat){
        int reglement = getTarifReglement(contrat);
        int diff = getDiffDateInMonths(contrat.getDateDebutConrat(),contrat.getDateFinConrat());
        System.out.println("Contrat " + contrat.getIdContact() + ": " + reglement + "*" + diff + "=" + reglement * diff);
        return reglement * (diff);
    }
    public void generatePDF(HttpServletResponse response) throws IOException {
        com.lowagie.text.Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        // Paragraph paragraph = new Paragraph("Contrat :"+contrat.getId(),fontTitle);
        Paragraph paragraph = new Paragraph("Reçu",fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("dateDebut:\t2022-05-07\ndateFin:\t2023-05-11\nSpecialité:\tCLOUD\nMontant:\t4000");
        // Paragraph paragraph2 = new Paragraph("dateDebut :"+contrat.getDateDebut() +"\n dateFin :"+contrat.getDateFin() +"\n Specialité :"+ contrat.getSpecialite() +"\n Montant :"+contrat.getMontant());
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph2);
        document.close();
    }

    public Contrat affectContratToEtudiant(Contrat contrat, String nomE, String prenomE) {
        contrat.setEtudiant(etudiantRepository.findByNomEAndPrenomE(nomE, prenomE));
        return contratRepository.save(contrat);
    }

//    @Override
//    public Integer nbContratsValides(Date startDate, Date endDate) {
//        int nb=0;
//        List<Contrat>C=contratRepository.findContratByDateFinContratBetween(startDate,endDate);
//
//        for(int i=0;i<C.size();i++){
//            if(C.get(i).getArchive()==false){
//                nb ++;
//            }
//        }
//        return nb;

    
//    }

}
