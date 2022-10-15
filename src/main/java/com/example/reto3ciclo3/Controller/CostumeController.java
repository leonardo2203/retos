package com.example.reto3ciclo3.Controller;

import com.example.reto3ciclo3.Modelo.Costume;

import com.example.reto3ciclo3.services.Costumeservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Costume")

public class CostumeController {
    @Autowired

        private Costumeservices costumeservices;

        @GetMapping("/all")
        public List<Costume> getAll(){
            return costumeservices.getAll();
        }
        @PostMapping("/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Costume save(@RequestBody Costume c){
            return costumeservices.save(c);

        }
}
