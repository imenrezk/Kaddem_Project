package com.example.springatelier.service;


import com.example.springatelier.Repositories.EquipeRepository;
import com.example.springatelier.entities.Equipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService {

    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipe(){
        return equipeRepository.findAll();
    }

    @Override
    public   Equipe addEquipe(Equipe E){
        return equipeRepository.save(E);
    }
    @Override
    public  void deleteEquipe(Integer idEquipe){
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public    Equipe updateEquipe(Equipe E){
     return equipeRepository.save(E);
    }

    @Override
   public Equipe retrieveEquipe(Integer idEquipe){
        return equipeRepository.findById(idEquipe).orElse(null);
    }


}
