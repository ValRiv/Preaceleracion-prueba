package com.disney.preaceleracion.Repository.PersonajeSpecification;

import com.disney.preaceleracion.Entity.PersonajeEntity;
import com.disney.preaceleracion.dto.PersonajeFiltersDTO
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class PersonajeSpecification {
    // RECIBE LA LISTA DE DTO FILTERS
    public Specification<PersonajeEntity> getByFilters(PersonajeFiltersDTO filterDTO) {

        // LAMBDA FUNCION
        return (root, query, criteriaBuilder) -> {

            // LISTA DE PREDICATES ES CREADA
            List<Predicate> predicates = new ArrayList<>();


            // FILTRAR POR NOMBRE
            if (StringUtils.hasLength(filterDTO.getNombre())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")),
                                "%" + filterDTO.getNombre().toLowerCase() + "%"));
            }

            