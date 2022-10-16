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

    public Costume save(Costume p) {
        if (p.getId() == null) {
            return costumeRepository.save(p);
        } else {
            Optional<Costume> e = costumeRepository.getCostume(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return costumeRepository.save(p);
            }
        }
    }

    public Costume update(Costume p) {
        if (p.getId() != null) {
            Optional<Costume> q = costumeRepository.getCostume(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }
                if (p.getDescription() != null) {
                    q.get().setDescription(p.getDescription());
                }
                if (p.getBrand() != null) {
                    q.get().setBrand(p.getBrand());
                }
                if (p.getYear() != null) {
                    q.get().setYear(p.getYear());
                }

                costumeRepository.save(q.get());
                return q.get();
            } else {
                return p;
            }
        } else {
            return p;
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
