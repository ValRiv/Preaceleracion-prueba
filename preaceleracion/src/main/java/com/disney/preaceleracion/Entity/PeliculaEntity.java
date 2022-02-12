package com.disney.preaceleracion.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.SetJoin;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table (name="Pelicula")


public class PeliculaEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    private String imagen;
    private String titulo;

    @Column (name="fecha_creacion")
    @DateTimeFormat(pattern = "YYYY/MM/DD")
    private LocalDate fechaDeCreacion;

    private int calificacion;

    //Busco info y traigo objeto genero
    @ManyToOne(fetch = FetchType.EAGER, cascade  = CascadeType.ALL)
    @JoinColumn(name = "genero_id", insertable = false, updatable = false)
    private GeneroEntity genero;

    //Guardo y actualizo donde esta el id genero
    @Column(name="genero_id" , nullable = false)
    private Long generoId;

    //creo tabla intermedia entre pelicula y personaje con un jointable

    @ManyToMany(
            cascade =  {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name= "personaje_pelicula",
            joinColumns = @JoinColumn (name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private Set<PersonajeEntity> personaje= new HashSet<>();
}
