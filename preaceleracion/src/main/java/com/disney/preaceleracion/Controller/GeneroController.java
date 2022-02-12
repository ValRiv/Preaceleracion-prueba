package com.disney.preaceleracion.Controller;

import com.disney.preaceleracion.Service.GeneroService;
import com.disney.preaceleracion.Service.Impl.GeneroServiceImpl;
import com.disney.preaceleracion.dto.GeneroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
 public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroDto>>getAll() {
        List<GeneroDto>generos = this.generoService.getAllGeneros();
        return ResponseEntity.ok().body(generos);
    }

    @PostMapping
    public ResponseEntity<GeneroDto> save(@RequestBody GeneroDto genero){
        //save genero
        //201 genero guardado
        GeneroDto generoGuardado= generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }
}

