package com.example.springatelier.Repositories;

import com.example.springatelier.entities.Departement;
import com.example.springatelier.entities.Option;
import com.example.springatelier.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {

    @Query("SELECT departement from Departement departement ,Etudiant etudiant " +
            " where etudiant.departement.idDepart =departement.idDepart and etudiant.option =:option")
    List<Departement> retrievedepartementByoption( Option option);




    @Query("SELECT departement from Departement departement ,Etudiant etudiant,Contrat contrat"+
            " where etudiant.departement.idDepart=departement.idDepart and etudiant.idEtudiant=contrat.etudiant.idEtudiant and contrat.specialite =?1")

    List<Departement> retrievedepartementByspecialitedecontrat(Specialite specialite);


    @Query("SELECT nbrEmployes from Departement "+"where nomDepartement=?1")
    int nbrEmployeDepartement(String nomDepartement);

    @Query( "SELECT departement FROM Departement departement "+
            "            GROUP BY(departement.idDepart )" +
            "            ORDER BY(departement.nbrEmployes ) DESC")
    List<Departement> triDepartement();

    @Query ("SELECT departement from Departement departement , Etudiant  etudiant "+
            " where etudiant.departement.idDepart =departement.idDepart and etudiant.nomE=:nomE and etudiant.idEtudiant=:idEtudiant")
    List<Departement> departementEtudiant (String  nomE, Integer idEtudiant);
}
