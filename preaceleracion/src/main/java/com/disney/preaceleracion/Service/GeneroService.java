package com.disney.preaceleracion.Service;

import com.disney.preaceleracion.dto.GeneroDto;

import java.util.List;

public interface GeneroService {
    public GeneroDto save(GeneroDto dto);

    List<GeneroDto> getAllGeneros();
}
