package com.example.springatelier.Repositories;
import com.example.springatelier.entities.Contrat;
import com.example.springatelier.entities.Etudiant;
import com.example.springatelier.entities.Option;
import com.example.springatelier.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

    @Query("Select E from Etudiant E WHERE E.departement.idDepart = ?1 ")
        List<Etudiant> getEtudiantsByDepartement(Integer idDepart);

    Etudiant findByNomEAndPrenomE(String nomE,String prenomE);

     List<Etudiant> findByDepartementIdDepart(int idDepart);

   // List<Etudiant> findByEquipeidEquipe(int idEquipe);


    @Query(value = "SELECT * FROM Etudiant e"
            + " INNER JOIN Equipe eq"
            +"INNER JOIN equipe_etudiants eqq"
            + " INNER JOIN detail_equipe detail"
            + " ON detail.id_detail_equipe  = eq.detail.id_detail_equipe  "
            + " and detail.thematique =:thematique" , nativeQuery = true)

    public    List<Etudiant> retrieveEtudiantBythematique(@Param("thematique") String thematique);

//    SELECT * FROM etudiant e INNER JOIN equipe_etudiants eq INNER JOIN detail_equipe de INNER JOIN equipe eqq
//    on e.id_etudiant=eq.etudiants_id_etudiant AND eq.equipes_id_equipe=eqq.id_equipe
//    AND eqq.detail_equipe_id_detail_equipe=de.id_detail_equipe WHERE de.thematique="anglais";


//    @Query("SELECT etudiant from Etudiant e,e.Equipes Equipe ,DetailEquipe de ,Equipe eqq"+
//    "where Equipe.etudiants_id_etudiant=e.idEtudiant and Equipe.equipes_id_equipe=eqq.idEquipe and eqq.detail_equipe_id_detail_equipe=de.idDetailEquipe and de.thematique =?1 ")

//     @Query(value = "SELECT Etudiant from Etudiant e" +
//     "INNER JOIN e.Equipe eq" +
//     "INNER JOIN DetailEquipe  de"+
//     "INNER JOIN Equipe eqq")
    //List<Etudiant> retrieveEtudiantBythematique(String thematique);

    @Query("SELECT etudiant from Etudiant etudiant ,Contrat contrat" +
            " where etudiant.idEtudiant=contrat.etudiant.idEtudiant and contrat.specialite =?1")
        List<Etudiant> retrieveEntreprisesBySpecialiteEquipe( Specialite specialite);

   List<Etudiant>findByOption( Option option);

    @Query("SELECT COUNT(etudiant) FROM Etudiant etudiant ,Departement departement " +
    "where etudiant.departement.idDepart=departement.idDepart and departement.idDepart =?1")
         int nbrEtudiantDepartement(Integer idDepart);

    @Query("SELECT etudiant from Etudiant etudiant" +
            " GROUP BY (etudiant.idEtudiant)" +
            "ORDER BY (etudiant.nomE) ASC")
    List<Etudiant> triEtudiant();

    @Query("SELECT etudiant from Etudiant etudiant ,Contrat contrat" +
            " where etudiant.idEtudiant=contrat.etudiant.idEtudiant and contrat.dateDebutConrat > current_date and contrat.archive =?1")
    List<Etudiant> retrieveEtudiantByarchiveEquipe (boolean archive);
    //et qui n’a pas encore commencé


//    @Query("SELECT etudiant from Etudiant etudiant ,Contrat contrat" +
//            " where etudiant.idEtudiant=contrat.etudiant.idEtudiant and contrat.montantContrat BETWEEN ?100 and ?10000 ")
//    List<Etudiant> retrieveEtudiantByMontantcontrat (Integer montantContrat);

    @Query("DELETE from Etudiant e " +
            "where e.option is null")
    void deleteEtudiantOption();





}
