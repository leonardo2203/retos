package com.example.reto3ciclo3.Controller;

import com.example.reto3ciclo3.Modelo.Costume;

import com.example.reto3ciclo3.services.CostumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Costume")

public class CostumeController {
    @Autowired

        private CostumeService costumeservice;

        @GetMapping("/all")
        @PostMapping("/all")
        public List<Costume> getAll(){
            return costumeservice.getAll();
        }
        @PostMapping("/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Costume save(@RequestBody Costume costume){
            return costumeservice.save(costume);

        }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume update(@RequestBody Costume costume ){
        return costumeservice.update(costume);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return costumeservice.deleteCustome( id);
    }
}
