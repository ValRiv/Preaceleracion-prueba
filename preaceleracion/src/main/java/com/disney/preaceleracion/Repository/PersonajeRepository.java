package com.disney.preaceleracion.Repository;


import com.disney.preaceleracion.Entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity,Long> {
}
