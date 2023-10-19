package com.example.springatelier.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name="idEquipe")
    private Integer idEquipe; // Clé primaire
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private niveau Niveau;

    @OneToOne(cascade = CascadeType.ALL)
    private DetailEquipe detailEquipe;
    @ManyToMany()
    private Set<Etudiant> etudiants;
    @ManyToOne
    Entreprise entreprise;

}
