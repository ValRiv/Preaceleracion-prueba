package com.disney.preaceleracion.Service;

import com.disney.preaceleracion.dto.PeliculaDto;
import com.disney.preaceleracion.dto.PeliculaDto;

import java.util.List;

public interface PeliculaService {
    

    
    public PeliculaDto savePelicula(PeliculaDto PeliculaDto);

    //    public PeliculaDtoBasic savePeliculaBasic(PeliculaDtoBasic PeliculaDto);

    public List<PeliculaDto> getAllPelicula();

    public void deletePelicula(Long idPelicula);

    public PeliculaDto modifyPelicula(Long idPelicula, PeliculaDto PeliculaDto);
}
