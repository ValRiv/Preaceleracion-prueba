package com.disney.preaceleracion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeFiltersDTO {
    private String nombre;
    private Long Edad;
    private List<Long> Peliculas;


}

