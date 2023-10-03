package com.example.demo.services;

import com.example.demo.entities.Persona;
import com.example.demo.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

public class PersonaService implements BaseService<Persona>{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try{
            List<Persona> entities = personaRepository.findAll();
            return entities;
        }catch (Exception E){
            throw new Exception(E.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception E){
            throw new Exception(E.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try{
            entity = personaRepository.save(entity);
            return entity;
        }catch (Exception E){
            throw new Exception(E.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(persona);
            return persona;
        }catch (Exception E){
            throw new Exception(E.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception E){
            throw new Exception(E.getMessage());
        }
    }
}
