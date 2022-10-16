package com.example.reto3ciclo3.services;

import com.example.reto3ciclo3.Modelo.Score;

import com.example.reto3ciclo3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score p){
        if (p.getId() == null) {
            return scoreRepository.save(p);
        } else {
            Optional<Score> e = scoreRepository.getScore(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return scoreRepository.save(p);
            }
        }
    }



    public boolean delete(int id) {
        boolean flag = false;
        Optional<Score> p = scoreRepository.getScore(id);
        if (p.isPresent()) {
            scoreRepository.delete(p.get());
            flag = true;
        }
        return flag;

    }
}
