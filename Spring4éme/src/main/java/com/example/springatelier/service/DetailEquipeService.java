package com.example.springatelier.service;

import com.example.springatelier.Repositories.DetailEquipeRepository;
import com.example.springatelier.entities.DetailEquipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailEquipeService implements IDetailEquipeService{
    DetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> retrieveAllDEquipeService(){
        return detailEquipeRepository.findAll();
    }
    @Override
    public  DetailEquipe addDetailEquipe(DetailEquipe DE){
        return detailEquipeRepository.save(DE);
    }
    @Override
    public   void deleteDetailEquipe(Integer idDetailEquipe){
        detailEquipeRepository.deleteById(idDetailEquipe);
    }

    @Override
    public  DetailEquipe updateDetailEquipe(DetailEquipe DE){
        return detailEquipeRepository.save(DE);
    }
    @Override
    public  DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe){
        return detailEquipeRepository.findById(idDetailEquipe).orElse(null);
    }

}
