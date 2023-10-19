package com.example.springatelier.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name="idEtudiant")
    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option  option;

    @OneToMany( mappedBy = "etudiant")
    @JsonIgnore
    private Set <Contrat> Contrats;

    @ManyToOne()
    @JsonIgnore
    private Departement departement;

    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    private Set<Equipe> equipes;


}
