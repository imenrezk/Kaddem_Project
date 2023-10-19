package com.example.springatelier.service;

import com.example.springatelier.entities.Contrat;
import com.example.springatelier.entities.Etudiant;
import com.example.springatelier.entities.Option;
import com.example.springatelier.entities.Specialite;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEtudiantService {



    List<Etudiant> retrieveAllEtudiant();

    Etudiant addEtudiant(Etudiant Et);

    void deleteEtudiant(Integer idEtudiant);

    Etudiant updateEtudiant(Etudiant Et);

    Etudiant retrieveEtudiant(Integer idEtudiant);

  //  boolean addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    List<Etudiant> getEtudiantsByDepartement (Integer idDepart);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);

    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);

    //List<Etudiant> getEtudiantsByEquipe (Integer idEquipe);
      List<Etudiant> retrieveEtudiantBythematiquee(String thematique);

    List<Etudiant> retrieveEntreprisesBySpecialiteEquipee( Specialite specialite);

    List<Etudiant> retrieveEtudiantByoptionn( Option option);
     int NBREtudiantDepartement(Integer idDepart);
      List<Etudiant> TRIEtudiant();

    List<Etudiant> retrieveEtudiantByarchiveEquipee (boolean archive);
  //  List<Etudiant> retrieveEtudiantByMontantcontratt (Integer montantContrat);

    void deleteEtudiantOptionn();

}
