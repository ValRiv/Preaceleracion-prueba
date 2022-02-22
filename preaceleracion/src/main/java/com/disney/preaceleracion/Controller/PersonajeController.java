package com.disney.preaceleracion.Controller;

import com.disney.preaceleracion.Entity.PeliculaEntity;
import com.disney.preaceleracion.Service.PersonajeService;
import com.disney.preaceleracion.dto.PersonajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("personajes")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;
    @Autowired
    private PeliculaEntity peliculaEntity;
    @GetMapping
    public ResponseEntity<List<PersonajeDto>> getAll() {
        List<PersonajeDto>personajes = this.personajeService.getAllPersonaje();
        return ResponseEntity.ok().body(personajes);
    }

    @PostMapping
    public ResponseEntity<PersonajeDto> savePersonaje(@RequestBody PersonajeDto personaje){
        //save genero
        //201 genero guardado
        PersonajeDto personajeGuardado= personajeService.savePersonaje(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        this.personajeService.deletePersonaje(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    @GetMapping
    public ResponseEntity<List<PersonajeDto>> getDetailsByFilters(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long Edad,
            @RequestParam(required = false)List<Long> peliculas

            )
    { List<PersonajeDto>personajes = this.personajeService.getPersonajeByFilters(nombre,Edad,peliculas);
    return ResponseEntity.ok(personajes);
    }
}



