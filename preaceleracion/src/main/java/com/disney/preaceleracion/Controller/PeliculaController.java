package com.disney.preaceleracion.Controller;

import com.disney.preaceleracion.Service.PeliculaService;
import com.disney.preaceleracion.dto.PeliculaDto;
import com.disney.preaceleracion.dto.PersonajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("peliculas")

public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> getAll() {
        List<PeliculaDto>peliculas = this.peliculaService.getAllPelicula();
        return ResponseEntity.ok().body(peliculas);
    }

    @PostMapping
    public ResponseEntity<PeliculaDto> save(@RequestBody PeliculaDto peliculaDto){
        //save pelicula
        //201 pelicula guardado
        PeliculaDto peliculaGuardado= peliculaService.savePelicula(peliculaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardado);
    }

}

