package com.disney.preaceleracion.Mapper;


import com.disney.preaceleracion.Entity.PeliculaEntity;
import com.disney.preaceleracion.Entity.PersonajeEntity;
import com.disney.preaceleracion.dto.PeliculaDto;
import com.disney.preaceleracion.dto.PersonajeBasicDto;
import com.disney.preaceleracion.dto.PersonajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class PersonajeMapper {
    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PeliculaEntity peliculaEntity;
    @Autowired
    private PersonajeEntity personajeEntity;
    @Autowired
    private PersonajeDto personajeDto;

    public PersonajeEntity PersonajeDTO2Entity(PersonajeDto dto) {
        PersonajeEntity entity = new PersonajeEntity();
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
        entity.setPeso(dto.getPeso());
        entity.setHistoria(dto.getHistoria());
        return entity;
    }

    public PersonajeDto PersonajeEntity2Dto(PersonajeEntity entity, boolean loadPeliculas) {
        PersonajeDto dto = new PersonajeDto();
        dto.setId(entity.getId());
       dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        if (loadPeliculas){
            List<PeliculaDto> peliculaDTOList = new ArrayList<>();
            for (PeliculaEntity entity1 : personajeEntity.getPeliculas()) {
                peliculaDTOList.add(peliculaMapper.PeliculaEntity2Dto(entity1, false));
            }
            personajeDto.setPeliculas(peliculaDTOList);
        }

        return personajeDto;
    }


    public List<PersonajeDto> personajeEntityListDTO2List(List<PersonajeEntity> entities, boolean loadPelicula) {
        List<PersonajeDto> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities) {
            dtos.add(this.PersonajeEntity2Dto(entity, loadPelicula));

        }
        return dtos;
    }
    public List<PersonajeBasicDto> personajeEntitySet2BasicDtoList(Collection<PersonajeEntity>entities){
        List<PersonajeBasicDto>dtos= new ArrayList<>();
        PersonajeBasicDto basicDto;
        for (PersonajeEntity entity: entities) {
            basicDto = new PersonajeBasicDto();
            basicDto.setId(entity.getId());
            basicDto.setImagen(entity.getImagen());
            basicDto.setNombre(basicDto.getImagen());
            dtos.add(basicDto);
        }

              return dtos;
            
        }
    public List<PersonajeDto> personajeEntitySet2DTOList (Collection<PersonajeEntity>entities, boolean loadPeliculas){
        List<PersonajeDto>dtos= new ArrayList<>();
        for (PersonajeEntity entity:entities){
            dtos.add(this.PersonajeEntity2Dto(entity,loadPeliculas));

        }
        return dtos;
    }
    public List<PersonajeEntity>personajeDTOList2Entity(List<PersonajeDto>dtos){
        List<PersonajeEntity>entities= new ArrayList<>();
        for (PersonajeDto dto: dtos){
            entities.add(PersonajeDTO2Entity(dto));
        }
        return  entities;
    }

    }
