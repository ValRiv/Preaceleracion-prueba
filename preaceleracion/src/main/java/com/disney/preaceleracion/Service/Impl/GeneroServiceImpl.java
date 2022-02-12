package com.disney.preaceleracion.Service.Impl;

import com.disney.preaceleracion.Entity.GeneroEntity;
import com.disney.preaceleracion.Mapper.GeneroMapper;
import com.disney.preaceleracion.Repository.GeneroRepository;
import com.disney.preaceleracion.Service.GeneroService;
import com.disney.preaceleracion.dto.GeneroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDto save(GeneroDto dto){
        GeneroEntity entity = generoMapper.GeneroDTO2Entity(dto);
        //guardad continente
         GeneroEntity entitysaved = generoRepository.save(entity);
         GeneroDto result = generoMapper.GeneroEntity2Dto(entitysaved);
        System.out.println("GUARDAR GENERO");
        return result;
    }
    public List<GeneroDto> getAllGeneros(){
        List<GeneroEntity>entities = generoRepository.findAll();
        List<GeneroDto>result =  generoMapper.generoEntetyListDTO2EntityList(entities);
        return result;
    }
}
