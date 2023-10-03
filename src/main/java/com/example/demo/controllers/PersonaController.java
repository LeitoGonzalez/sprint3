package com.example.demo.controllers;

import com.example.demo.entities.Persona;
import com.example.demo.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController {
    private PersonaService personaService;

    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }


    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        }catch (Exception e){
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    public ResponseEntity<?> save(Persona entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }


}