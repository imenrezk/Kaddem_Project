package com.example.springatelier.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springatelier.entities.Universite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {

    Universite findAllByIdUniv(Integer idUniversite);

    @Query("SELECT universite from Universite universite"+
            "   GROUP BY (universite.idUniv)"+
            "   ORDER BY (universite.nomUniv) DESC ")
    List<Universite> triunversite();
    @Query("SELECT u FROM Universite u  WHERE u.diplomes=?1")
    List<Universite> getUniversiteByDiplome(String diplomes);
    @Query(value = "SELECT COUNT(departements_id_depart ) FROM universite_departements  \n" +
            "WHERE universite_id_univ=:id", nativeQuery = true)
    int nbrdepUniv(@Param("id") Integer id);
//    @Query(value = "SELECT COUNT(e.id_etudiant) FROM etudiant e\n" +
//            "LEFT JOIN departement d ON d.id_depart =e.departement_id_depart \n" +
//            "LEFT JOIN universite u ON u.id_univ = d.id_univ\n" +
//            "WHERE id_univ= :id", nativeQuery = true)
//    int nbretudUniv(@Param("id") Integer id);
    @Query("SELECT universite from Universite  universite " +
            "where  universite.nomUniv =?1")
    List<Universite>retrieveUniversiteBynom(String nomUniv);

    @Override
    List<Universite> findAll();
}
