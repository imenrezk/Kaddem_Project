package com.example.springatelier.service;

import com.example.springatelier.entities.Departement;
import com.example.springatelier.entities.DetailEquipe;
import com.example.springatelier.entities.Equipe;

import java.util.List;

public interface IDetailEquipeService {

    List<DetailEquipe> retrieveAllDEquipeService();

    DetailEquipe addDetailEquipe(DetailEquipe DE);

    void deleteDetailEquipe(Integer idDetailEquipe);

    DetailEquipe updateDetailEquipe(DetailEquipe DE);

    DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe);
}
