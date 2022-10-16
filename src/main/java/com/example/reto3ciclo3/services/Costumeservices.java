package com.example.reto3ciclo3.services;

import com.example.reto3ciclo3.Modelo.Costume;

import com.example.reto3ciclo3.Repository.CostumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Costumeservices {

    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll() {
        return costumeRepository.getAll();
    }

    public Optional<Costume> getId(int id) {
        return costumeRepository.getCostume(id);
    }

    public Costume save(Costume l) {
        if (l.getId() == null) {
            return costumeRepository.save(l);
        } else {
            Optional<Costume> e = costumeRepository.getCostume(l.getId());
            if (e.isPresent()) {
                return l;
            } else {
                return costumeRepository.save(l);
            }
        }
    }

    public Costume update(Costume l) {
        if (l.getId() != null) {
            Optional<Costume> q = costumeRepository.getCostume(l.getId());
            if (q.isPresent()) {
                if (l.getName() != null) {
                    q.get().setName(l.getName());
                }
                if (l.getDescription() != null) {
                    q.get().setDescription(l.getDescription());
                }
                if (l.getBrand() != null) {
                    q.get().setBrand(l.getBrand());
                }
                if (l.getYear() != null) {
                    q.get().setYear(l.getYear());
                }
                if(l.getCategory()!=null){
                    q.get().setCategory(l.getCategory());
                }
                if(l.getMessages()!=null) {
                    q.get().setMessages(l.getMessages());
                }
                if(l.getReservations()!=null){
                    q.get().setReservations(l.getReservations());
                }

                costumeRepository.save(q.get());
                return q.get();
            } else {
                return l;
            }
        } else {
            return l;
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
