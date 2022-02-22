package com.disney.preaceleracion.Service;



import com.disney.preaceleracion.dto.PersonajeDto;

import java.util.List;
import java.util.Set;

public interface PersonajeService {

    public PersonajeDto savePersonaje(PersonajeDto PersonajeDto);

    //    public PersonajeDtoBasic savePersonajeBasic(PersonajeDtoBasic PersonajeDto);
//    
    public List<PersonajeDto> getAllPersonaje();

    public void deletePersonaje(Long idPersonaje);

    public PersonajeDto modifyPersonaje(Long idPersonaje, PersonajeDto PersonajeDto);

   // List<PersonajeDtoBasic> getBasicPersonajeList();

    //public PersonajeEntity getPersonajeById(Long idPersonaje);

    public List<PersonajeDto> getPersonajeByFilters(String nombre, Long Edad, List<Long> Peliculas);

    //public PersonajeDto getPersonajeDetailById(Long idPersonaje);

    //public void addPelicula(Long idPersonaje, Long idPelicula);

   // public void removePelicula(Long idPersonaje, Long idPelicula);

}

