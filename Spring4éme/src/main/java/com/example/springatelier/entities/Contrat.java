package com.example.springatelier.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contrat  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name="idContact")
    private Integer idContact; // Clé primaire
    @Temporal(TemporalType.DATE)
    private Date dateDebutConrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinConrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private  boolean archive;
    private Integer montantContrat;

    @ManyToOne(cascade = CascadeType.ALL)
    private Etudiant etudiant;



}


    //new Contrat contrat= Contrat.builder().build();


