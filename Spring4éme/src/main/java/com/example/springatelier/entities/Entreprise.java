package com.example.springatelier.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Entreprise {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntreprise;

    private String nomEntreprise;
    private String localisation;
    private String emailEntreprise;

    private boolean recruiting;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateDebutAlternance;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateDFinAlternance;



    @OneToMany(cascade =CascadeType.ALL,mappedBy = "entreprise")
    private Set<Equipe> equipes;


}
