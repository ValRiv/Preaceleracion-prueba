package com.disney.preaceleracion.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

@Setter
@Getter
public class PeliculaDto {
    private long Id;
    private String imagen;
    private String titulo;

    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "YYYY/MM/DD")
    private LocalDate fechaDeCreacion;

    private int calificacion;

}
