package com.example.reto3ciclo3.services;


import com.example.reto3ciclo3.Modelo.Category;

import com.example.reto3ciclo3.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category p){
        if (p.getId()==null){
            return categoryRepository.save(p);
        }else {
            Optional<Category> e = categoryRepository.getCategory(p.getId());
            if (e.isPresent()){
                return p;
            }else{
                return categoryRepository.save(p);
            }
        }
    }


    public Category update(Category category){
        if (category.getId()!=null){
            Optional<Category> q = categoryRepository.getCategory(category.getId());
            if (q.isPresent()){
                if (category.getDescription() !=null) {
                    q.get().setDescription(category.getDescription());
                }if (category.getName()!=null){
                    q.get().setName(category.getName());
                }
                return categoryRepository.save(q.get());
            }
        }
        return category;
    }
    public boolean deleteCategory (int id){
        return getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
    }



    }


