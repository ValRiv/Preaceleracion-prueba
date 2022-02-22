package com.disney.preaceleracion.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Setter
@Getter
public class PersonajeDto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String imagen;
    private String nombre;
    private Long Edad;
    private Long peso;
    private String historia;
    private List<PeliculaDto>peliculas;

}
