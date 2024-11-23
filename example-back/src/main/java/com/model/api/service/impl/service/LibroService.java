package com.model.api.service.impl.service;

import com.model.api.service.impl.dto.LibroDTO;

import java.util.List;

public interface LibroService {

    LibroDTO crearLibro(LibroDTO libroDTO);

    LibroDTO obtenerLibroPorId(Long id);

    LibroDTO actualizarLibro(Long id, LibroDTO libroDTO);

    void eliminarLibro(Long id);

    List<LibroDTO> listarTodosLosLibros();
}
