package com.disney.preaceleracion.Service.Impl;


import com.disney.preaceleracion.Entity.PersonajeEntity;
import com.disney.preaceleracion.Mapper.PeliculaMapper;
import com.disney.preaceleracion.Mapper.PersonajeMapper;
import com.disney.preaceleracion.Repository.PersonajeRepository;
import com.disney.preaceleracion.Repository.PersonajeSpecification.PersonajeSpecification;
import com.disney.preaceleracion.Service.PeliculaService;
import com.disney.preaceleracion.Service.PersonajeService;
import com.disney.preaceleracion.dto.PersonajeBasicDto;
import com.disney.preaceleracion.dto.PersonajeDto;
import com.disney.preaceleracion.dto.PersonajeFiltersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonajeServicelmpl implements PersonajeService {

    @Lazy
    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    PeliculaMapper peliculaMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PersonajeDto personajeDto;

    //@Lazy
    //@Autowired
    //private PersonajeSpecification personajeSpecification;

    @Lazy
    @Autowired
    private PeliculaService peliculaService;
    private PersonajeSpecification personajeSpecification;



    /**
     * Metodo para guardar un personaje
     *
     * @param personajeDto
     * @return
     * Recibe una personaje de tipo dto
     * esta dto la paso a entidad despues lo guardo en base de datos
     * esta etidad guardada la paso a dto
     */
    @Override
    public PersonajeDto savePersonaje(PersonajeDto personajeDto) {
        PersonajeEntity personajeEntity =  personajeMapper.PersonajeDTO2Entity(personajeDto);
        PersonajeEntity personajeGuardado= personajeRepository.save(personajeEntity);
        PersonajeDto personajeDtoGuardado =personajeMapper.PersonajeEntity2Dto(personajeGuardado,false);
        return personajeDtoGuardado;
    }

    @Override
    public List<PersonajeDto> getAllPersonaje() {
        List<PersonajeEntity>personajeEntityList=personajeRepository.findAll();
        List<PersonajeDto>personajeDtoList=personajeMapper.personajeEntityListDTO2List(personajeEntityList,true);
    return personajeDtoList;
    }


    @Override
    public void deletePersonaje(Long idPersonaje) {
        personajeRepository.deleteById(idPersonaje);


    }

    @Override
    public PersonajeDto modifyPersonaje(Long idPersonaje, PersonajeDto personajeDto) {
        //creo entidad
        PersonajeEntity personajeGuardado= personajeRepository.getById(idPersonaje);

        personajeGuardado.setNombre(personajeDto.getNombre());
        personajeGuardado.setImagen(personajeDto.getImagen());
        personajeGuardado.setPeso(personajeDto.getPeso());
        personajeGuardado.setEdad(personajeDto.getEdad());
        personajeGuardado.setHistoria(personajeDto.getHistoria());
        personajeGuardado.setPeliculas(peliculaMapper.PeliculaDTOList2EntityList(personajeDto.getPeliculas(),false));

        PersonajeEntity personajeEditado=personajeRepository.save(personajeGuardado);
        PersonajeDto personajeDtoGuardado=personajeMapper.PersonajeEntity2Dto(personajeEditado,false);

        return personajeDtoGuardado;
    }

    @Override
    public List<PersonajeDto> getPersonajeByFilters(String nombre, Long Edad, List<Long> Peliculas) {
        // Intancio los filtros
        PersonajeFiltersDTO characterFilter = new PersonajeFiltersDTO(nombre, Edad, Peliculas);

        // WE SEARCH ACCORDING TO FILTERS
        List<PersonajeEntity> characterEntities = personajeRepository.findAll(personajeSpecification.getByFilters(personajeFilter));

        // WE CONVERT THE LIST TO DTO
        List<PersonajeDto> personajeDTOList = personajeMapper.personajeEntityList2DTOList(personajeEntities, true);

        return personajeDTOList;
    }

    }


}

