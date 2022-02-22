package com.disney.preaceleracion.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name="Personaje")
@Getter
@Setter
@SQLDelete(sql = "UPDATE Personaje SET delete=true WHERE id=?")
@Where(clause = "delete=false")
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


    @ManyToMany(mappedBy = "personaje")
    private List<PeliculaEntity> peliculas= new ArrayList<>();

    //Agrego un booleano como atributo para no formar un bucle infinito y se inicializa en false
    private Boolean delete= Boolean.FALSE;

    public void addPelicula(PeliculaEntity pelicula) {
        this.peliculas.add(pelicula);
    }


    public void removePelicula(PeliculaEntity pelicula) {
        peliculas.remove(pelicula);
    }
}









