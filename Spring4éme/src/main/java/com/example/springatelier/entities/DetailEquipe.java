package com.example.springatelier.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name="idDetailEquipe")
    private Integer idDetailEquipe; // Clé primaire
    private Integer salle;
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    @JsonIgnore //wa9teha tla9a el equipe ma3dech edjo=ibhouli mara o5ra
    private Equipe equipe;

}
