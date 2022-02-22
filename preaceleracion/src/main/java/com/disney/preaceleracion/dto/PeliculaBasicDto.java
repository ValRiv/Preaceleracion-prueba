package com.disney.preaceleracion.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PeliculaBasicDto {
    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaDeCreacion;
}
