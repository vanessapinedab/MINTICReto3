package com.usa.ciclo3.reto3.services;


import java.util.List;
import java.util.Optional;

import com.usa.ciclo3.reto3.model.Specialty;
import com.usa.ciclo3.reto3.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServices {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll() {

        return specialtyRepository.getAll();
    }

    public Optional<Specialty> getSpecialty(int id) {

        return specialtyRepository.getSpecialty(id);
    }

    public Specialty save(Specialty specialty) {
        if (specialty.getId()== null) {
            return specialtyRepository.save(specialty);
        } else {
            Optional<Specialty> ct = specialtyRepository.getSpecialty(specialty.getId());
            if (ct.isEmpty()) {
                return specialtyRepository.save(specialty);
            } else {
                return specialty;
            }
        }
    }

    public Specialty update(Specialty specialty) {
        if (specialty.getId() != null) {
            Optional<Specialty> g = specialtyRepository.getSpecialty(specialty.getId());
            if (!g.isEmpty()) {
                if (specialty.getDescription() != null) {
                    g.get().setDescription(specialty.getDescription());
                }
                if (specialty.getName() != null) {
                    g.get().setName(specialty.getName());
                }
                specialtyRepository.save(g.get());
                return g.get();

            } else {
                return specialty;
            }
        } else{
                return specialty;
            }

    }

    public boolean deleteSpecialty(int id){
        Boolean aBoolean=getSpecialty(id).map(specialty -> {
            specialtyRepository.delete(specialty);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}


