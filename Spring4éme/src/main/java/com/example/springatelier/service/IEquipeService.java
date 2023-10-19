package com.example.springatelier.service;


import com.example.springatelier.entities.Equipe;

import java.util.List;

public interface IEquipeService {


    List<Equipe> retrieveAllEquipe();

    Equipe addEquipe(Equipe E);

    void deleteEquipe(Integer idEquipe);

    Equipe updateEquipe(Equipe E);

    Equipe retrieveEquipe(Integer idEquipe);

}
