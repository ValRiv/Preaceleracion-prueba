package com.disney.preaceleracion.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="Personaje")
@Getter
@Setter
 public class PersonajeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String imagen;
    private String nombre;
    private Long Edad;
    private Long peso;
    private String historia;

    @ManyToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas= new ArrayList<>();
}
