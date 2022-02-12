package com.disney.preaceleracion.Service;


import com.disney.preaceleracion.dto.PersonajeDto;

import java.util.List;

public interface PersonajeService {
    public PersonajeDto save(PersonajeDto dto);

    List<PersonajeDto> getAllPersonajes();
}

