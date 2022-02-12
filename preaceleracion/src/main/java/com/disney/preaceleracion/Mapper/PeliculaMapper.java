package com.disney.preaceleracion.Mapper;


import com.disney.preaceleracion.Entity.PeliculaEntity;
import com.disney.preaceleracion.dto.PeliculaDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {
    public PeliculaEntity PeliculaDTO2Entity(PeliculaDto dto){
        PeliculaEntity peliculaEntity= new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaDeCreacion(dto.getFechaDeCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        return peliculaEntity;
    }
    public PeliculaDto PeliculaEntity2Dto(PeliculaEntity entity){
        PeliculaDto dto = new PeliculaDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFechaDeCreacion(entity.getFechaDeCreacion());
        dto.setCalificacion(entity.getCalificacion());
        return dto;
    }
    public List<PeliculaDto> peliculaEntetyListDTO2EntityList(List<PeliculaEntity>entities){
        List<PeliculaDto>dtos =new ArrayList<>();
        for (PeliculaEntity entity: entities) {
            dtos.add(PeliculaEntity2Dto(entity));

        }
        return dtos;
    }
}
