package com.disney.preaceleracion.Controller;

import com.disney.preaceleracion.Service.PersonajeService;
import com.disney.preaceleracion.dto.PersonajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personajes")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;
    @GetMapping
    public ResponseEntity<List<PersonajeDto>> getAll() {
        List<PersonajeDto>personajes = this.personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(personajes);
    }

    @PostMapping
    public ResponseEntity<PersonajeDto> save(@RequestBody PersonajeDto personaje){
        //save genero
        //201 genero guardado
        PersonajeDto personajeGuardado= personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }
}



