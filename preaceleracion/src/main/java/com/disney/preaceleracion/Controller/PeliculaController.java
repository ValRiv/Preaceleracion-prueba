package com.disney.preaceleracion.Controller;

import com.disney.preaceleracion.Service.PeliculaService;
import com.disney.preaceleracion.dto.PeliculaDto;
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
        List<PeliculaDto>peliculas = this.peliculaService.getAllPeliculas();
        return ResponseEntity.ok().body(peliculas);
    }

    @PostMapping
    public ResponseEntity<PeliculaDto> save(@RequestBody PeliculaDto pelicula){
        //save pelicula
        //201 pelicula guardado
        PeliculaDto peliculaGuardado= peliculaService.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardado);
    }
}

