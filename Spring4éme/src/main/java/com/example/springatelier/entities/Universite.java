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
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name="idUniv")
    private Integer idUniv; // Clé primaire
    private String nomUniv;
    private String diplomes;
    @OneToMany()
    @JsonIgnore
    private Set<Departement> departements;
}
