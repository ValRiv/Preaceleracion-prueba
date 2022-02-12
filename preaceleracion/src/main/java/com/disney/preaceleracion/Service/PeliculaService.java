package com.disney.preaceleracion.Service;

import com.disney.preaceleracion.dto.PeliculaDto;

import java.util.List;

public interface PeliculaService {
    public PeliculaDto save(PeliculaDto dto);

    List<PeliculaDto> getAllPeliculas();
}
