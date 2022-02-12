package com.disney.preaceleracion.Entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name ="genero")

public class GeneroEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)

    private Long id;
    private String nombre;
    private String imagen;

    @ManyToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas= new ArrayList<>();

}

