package com.disney.preaceleracion.Service.Impl;

import com.disney.preaceleracion.Entity.GeneroEntity;
import com.disney.preaceleracion.Entity.GeneroEntity;
import com.disney.preaceleracion.Entity.PeliculaEntity;
import com.disney.preaceleracion.Entity.PersonajeEntity;
import com.disney.preaceleracion.Mapper.GeneroMapper;
import com.disney.preaceleracion.Mapper.PeliculaMapper;
import com.disney.preaceleracion.Repository.GeneroRepository;
import com.disney.preaceleracion.Service.GeneroService;
import com.disney.preaceleracion.dto.GeneroDto;
import com.disney.preaceleracion.dto.GeneroDto;
import com.disney.preaceleracion.dto.PeliculaDto;
import com.disney.preaceleracion.dto.PersonajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    GeneroEntity generoEntity;
    @Autowired
    GeneroDto generoDto;





    @Override
    public GeneroDto saveGenero(GeneroDto generoDto) {
        
            GeneroEntity generoEntity =  generoMapper.GeneroDTO2Entity(generoDto);
            GeneroEntity generoGuardado= generoRepository.save(generoEntity);
            GeneroDto GeneroDtoGuardado =generoMapper.GeneroEntity2Dto(generoGuardado);
            return GeneroDtoGuardado;
        }

    }




