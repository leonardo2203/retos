package com.example.reto3ciclo3.services;

import com.example.reto3ciclo3.Modelo.Costume;

import com.example.reto3ciclo3.Repository.CostumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumeService {

    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll() {
        return costumeRepository.getAll();
    }

    public Optional<Costume> getCostume(int id) {
        return costumeRepository.getCostume(id);
    }

    public Costume save(Costume costume) {
        if (costume.getId() == null) {
            return costumeRepository.save(costume);
        } else {
            Optional<Costume> e = costumeRepository.getCostume(costume.getId());
            if (e.isPresent()) {
                return costume;
            } else {
                return costumeRepository.save(costume);
            }
        }
    }

    public Costume update(Costume costume) {
        if (costume.getId() != null) {
            Optional<Costume> q = costumeRepository.getCostume(costume.getId());
            if (q.isPresent()) {
                if (costume.getName() != null) {
                    q.get().setName(costume.getName());
                }
                if (costume.getDescription() != null) {
                    q.get().setDescription(costume.getDescription());
                }
                if (costume.getBrand() != null) {
                    q.get().setBrand(costume.getBrand());
                }
                if (costume.getYear() != null) {
                    q.get().setYear(costume.getYear());
                }
                if(costume.getCategory()!=null){
                    q.get().setCategory(costume.getCategory());
                }
                if(costume.getMessages()!=null) {
                    q.get().setMessages(costume.getMessages());
                }
                if(costume.getReservations()!=null){
                    q.get().setReservations(costume.getReservations());
                }

                costumeRepository.save(q.get());
                return q.get();
            } else {
                return costume;
            }
        } else {
            return costume;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Costume> p = costumeRepository.getCostume(id);
        if (p.isPresent()) {
            costumeRepository.delete(p.get());
            flag = true;
        }
        return flag;

    }
}
