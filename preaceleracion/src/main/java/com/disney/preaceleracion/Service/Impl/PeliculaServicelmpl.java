package com.disney.preaceleracion.Service.Impl;


import com.disney.preaceleracion.Entity.PeliculaEntity;
import com.disney.preaceleracion.Entity.PersonajeEntity;
import com.disney.preaceleracion.Mapper.PeliculaMapper;
import com.disney.preaceleracion.Mapper.PersonajeMapper;
import com.disney.preaceleracion.Repository.PeliculaRepository;
import com.disney.preaceleracion.Repository.PersonajeRepository;
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
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PeliculaDto peliculaDto;
    @Autowired
    private PersonajeEntity personajeEntity;


    @Override
    public PeliculaDto savePelicula(PeliculaDto peliculaDto) {
        PeliculaEntity peliculaEntity = peliculaMapper.PeliculaDTO2Entity(peliculaDto);
        PeliculaEntity peliculaGuardado = peliculaRepository.save(peliculaEntity);
        PeliculaDto peliculaDtoGuardado = peliculaMapper.PeliculaEntity2Dto(peliculaGuardado, false);
        return peliculaDtoGuardado;
    }


    @Override
    public List<PeliculaDto> getAllPelicula() {
        List<PeliculaEntity> peliculaEntityList = peliculaRepository.findAll();
        List<PeliculaDto> peliculaDtoList = peliculaMapper.peliculaEntityListDTO2List(peliculaEntityList, true);
        return peliculaDtoList;

    }

    @Override
    public void deletePelicula(Long idPelicula) {
        peliculaRepository.deleteById(idPelicula);
    }

    @Override
    public PeliculaDto modifyPelicula(Long idPelicula, PeliculaDto peliculaDto) {
        //creo entidad
        PeliculaEntity peliculaGuardado = peliculaRepository.getById(idPelicula);

        peliculaGuardado.setTitulo(peliculaDto.getTitulo());
        peliculaGuardado.setImagen(peliculaDto.getImagen());
        peliculaGuardado.setFechaDeCreacion(peliculaDto.getFechaDeCreacion());
        peliculaGuardado.setCalificacion(peliculaDto.getCalificacion());


        PeliculaEntity peliculaEditado = peliculaRepository.save(peliculaGuardado);
        PeliculaDto peliculaDtoGuardado = peliculaMapper.PeliculaEntity2Dto(peliculaEditado, false);

        return peliculaDtoGuardado;
    }

}



