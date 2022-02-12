package com.disney.preaceleracion.Repository;

import com.disney.preaceleracion.Entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity,Long> {
}
