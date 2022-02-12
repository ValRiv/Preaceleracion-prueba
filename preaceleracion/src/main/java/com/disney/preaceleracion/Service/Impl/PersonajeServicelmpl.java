package com.disney.preaceleracion.Service.Impl;


import com.disney.preaceleracion.Entity.PersonajeEntity;
import com.disney.preaceleracion.Mapper.PersonajeMapper;
import com.disney.preaceleracion.Repository.PersonajeRepository;
import com.disney.preaceleracion.Service.PersonajeService;
import com.disney.preaceleracion.dto.PersonajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServicelmpl implements PersonajeService {
    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDto save(PersonajeDto dto){
        PersonajeEntity entity = personajeMapper.PersonajeDTO2Entity(dto);
        //guardar personaje
        PersonajeEntity entitysaved = personajeRepository.save(entity);
        PersonajeDto result = personajeMapper.PersonajeEntity2Dto(entitysaved);
        System.out.println("GUARDAR Personaje");
        return result;
    }
    public List<PersonajeDto> getAllPersonajes(){
        List<PersonajeEntity>entities = personajeRepository.findAll();
        List<PersonajeDto>result =  personajeMapper.personajeEntetyListDTO2EntityList(entities);
        return result;
    }
}
