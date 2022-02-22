package com.disney.preaceleracion.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.SetJoin;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@Table (name="Pelicula")
@SQLDelete(sql = "UPDATE Pelicula SET delete=true WHERE id=?")
@Where(clause = "delete=false")

public class PeliculaEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    private String imagen;
    private String titulo;

    @Column (name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD")
    private LocalDate fechaDeCreacion;

    private int calificacion;

    //Agrego un booleano como atributo para no formar un bucle infinito y se inicializa en false
    private Boolean delete= Boolean.FALSE;

    //Busco info y traigo objeto genero
    @ManyToOne(fetch = FetchType.EAGER)
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
    private List<PersonajeEntity> personaje= new ArrayList<>();

    public void addPersonaje(PersonajeEntity personaje) {
        this.personaje.add(personaje);
    }


    public void removePersonaje(PersonajeEntity personaje) {
        this.personaje.remove(personaje);
    }

}
