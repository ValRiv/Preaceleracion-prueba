package com.disney.preaceleracion.Mapper;

import com.disney.preaceleracion.Entity.GeneroEntity;
import com.disney.preaceleracion.dto.GeneroDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public GeneroEntity GeneroDTO2Entity(GeneroDto dto){
        GeneroEntity generoEntity= new GeneroEntity();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;
    }
    public GeneroDto GeneroEntity2Dto(GeneroEntity entity){
        GeneroDto dto = new GeneroDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        return dto;
    }
    public List<GeneroDto> generoEntityListDTO2List(List<GeneroEntity>entities){
        List<GeneroDto>dtos =new ArrayList<>();
        for (GeneroEntity entity: entities) {
            dtos.add(GeneroEntity2Dto(entity));
            
        }
        return dtos;
    }
}
