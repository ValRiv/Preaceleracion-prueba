package com.disney.preaceleracion.Mapper;


import com.disney.preaceleracion.Entity.PeliculaEntity;
import com.disney.preaceleracion.Entity.PersonajeEntity;
import com.disney.preaceleracion.dto.PeliculaBasicDto;
import com.disney.preaceleracion.dto.PeliculaDto;
import com.disney.preaceleracion.dto.PersonajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class PeliculaMapper {
    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeEntity personajeEntity;
    @Autowired
    private PeliculaDto peliculaDto;
    @Autowired
    PeliculaEntity peliculaEntity;

    public PeliculaEntity PeliculaDTO2Entity(PeliculaDto dto) {
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaDeCreacion(dto.getFechaDeCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGeneroId(dto.getGeneroId());
        return peliculaEntity;
    }

    public PeliculaDto PeliculaEntity2Dto(PeliculaEntity entity, boolean loadPersonajes) {
        PeliculaDto dto = new PeliculaDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFechaDeCreacion(entity.getFechaDeCreacion());
        dto.setCalificacion(entity.getCalificacion());
        dto.setGeneroId(entity.getGeneroId());

        if (loadPersonajes) {
            List<PersonajeDto> personajeDtoList = new ArrayList<>();
            for(PersonajeEntity entity1: peliculaEntity.getPersonaje()){
                personajeDtoList.add(personajeMapper.PersonajeEntity2Dto(entity1,false));

            }
            peliculaDto.setPersonajes(personajeDtoList);
        }

        return dto;
    }
    public List<PeliculaEntity> PeliculaDTOList2EntityList(List<PeliculaDto> peliculaDtoList, boolean loadPersonajes) {

        List<PeliculaEntity> PeliculaEntitiesList = new ArrayList<>();

        for (PeliculaDto dto : peliculaDtoList) {
            PeliculaEntitiesList.add(PeliculaDTO2Entity(dto, loadPersonajes));
        }
        return PeliculaEntitiesList;
    }
    public List<PeliculaEntity>peliculaDTOList2Entity(List<PeliculaDto>dtos){
        List<PeliculaEntity>entities= new ArrayList<>();
        for (PeliculaDto dto: dtos){
            entities.add(PeliculaDTO2Entity(dto));
        }
        return  entities;
    }
    public List<PeliculaDto> peliculaEntitySet2DTOList(Collection<PeliculaEntity> entities, boolean loadPersonajes) {
        List<PeliculaDto> dtos = new ArrayList<>();
        for (PeliculaEntity entity : entities) {
            dtos.add(this.PeliculaEntity2Dto(entity, loadPersonajes));

        }
        return dtos;
    }


    public List<PeliculaDto> peliculaEntityListDTO2List(List<PeliculaEntity> entities, boolean loadPersonaje) {
        List<PeliculaDto> dtos = new ArrayList<>();
        for (PeliculaEntity entity : entities) {
            dtos.add(this.PeliculaEntity2Dto(entity, loadPersonaje));

        }
        return dtos;
    }


    public List<PeliculaBasicDto> peliculaEntitySet2BasicDTOList(Collection<PeliculaEntity> entities) {
        List<PeliculaBasicDto> dtos = new ArrayList<>();
        PeliculaBasicDto basicDTO;
        for (PeliculaEntity entity : entities) {
            basicDTO = new PeliculaBasicDto();
            basicDTO.setId(entity.getId());
            basicDTO.setImagen(entity.getImagen());
            basicDTO.setTitulo(entity.getTitulo());
            basicDTO.setFechaDeCreacion(entity.getFechaDeCreacion());
            dtos.add(basicDTO);
        }
        return dtos;
    }

}







