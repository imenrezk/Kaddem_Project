package com.example.springatelier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public  class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name="idDepart")
    private Integer idDepart; // Clé primaire
    private String nomDepartement;
    private Integer nbrEmployes ;
    @OneToMany( mappedBy = "departement")
    @JsonIgnore
    private Set<Etudiant> etudiants;
}
