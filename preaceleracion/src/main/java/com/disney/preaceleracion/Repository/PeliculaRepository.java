package com.disney.preaceleracion.Repository;


import com.disney.preaceleracion.Entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity,Long> {
}
