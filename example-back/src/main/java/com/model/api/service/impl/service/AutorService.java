package com.model.api.service.impl.service;

import com.model.api.service.impl.dto.AutorDTO;

import java.util.List;

public interface AutorService {

    AutorDTO crearAutor(AutorDTO autorDTO);

    AutorDTO obtenerAutorPorId(Long id);

    AutorDTO actualizarAutor(Long id, AutorDTO autorDTO);

    void eliminarAutor(Long id);

    List<AutorDTO> listarTodosLosAutores();
}
