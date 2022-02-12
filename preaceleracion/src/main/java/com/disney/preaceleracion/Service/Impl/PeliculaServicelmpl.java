package com.disney.preaceleracion.Service.Impl;


import com.disney.preaceleracion.Entity.PeliculaEntity;
import com.disney.preaceleracion.Mapper.PeliculaMapper;
import com.disney.preaceleracion.Repository.PeliculaRepository;
import com.disney.preaceleracion.Service.PeliculaService;
import com.disney.preaceleracion.dto.PeliculaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServicelmpl implements PeliculaService {

    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaDto save(PeliculaDto dto){
        PeliculaEntity entity = peliculaMapper.PeliculaDTO2Entity(dto);
        //guardar pelicula
        PeliculaEntity entitysaved = peliculaRepository.save(entity);
        PeliculaDto result = peliculaMapper.PeliculaEntity2Dto(entitysaved);
        System.out.println("GUARDAR Pelicula");
        return result;
    }
    public List<PeliculaDto> getAllPeliculas(){
        List<PeliculaEntity>entities = peliculaRepository.findAll();
        List<PeliculaDto>result =  peliculaMapper.peliculaEntetyListDTO2EntityList(entities);
        return result;
    }

}
