package com.disney.preaceleracion.Mapper;


import com.disney.preaceleracion.Entity.PersonajeEntity;
import com.disney.preaceleracion.dto.PersonajeDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {
    public PersonajeEntity PersonajeDTO2Entity(PersonajeDto dto) {
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }

    public PersonajeDto PersonajeEntity2Dto(PersonajeEntity entity) {
        PersonajeDto dto = new PersonajeDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        return dto;
    }

    public List<PersonajeDto> personajeEntetyListDTO2EntityList(List<PersonajeEntity> entities) {
        List<PersonajeDto> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities) {
            dtos.add(PersonajeEntity2Dto(entity));

        }
        return dtos;
    }
}