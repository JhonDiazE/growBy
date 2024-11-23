package com.model.api.service.impl.mapper;

import com.model.api.service.impl.dto.LibroDTO;
import com.model.api.service.impl.model.Libro;

public class LibroMapper {

    public static LibroDTO convertToDTO(Libro libro) {
        return LibroDTO.builder()
                .id(libro.getId())
                .titulo(libro.getTitulo())
                .isbn(libro.getIsbn())
                .disponible(libro.getDisponible())
                .autor(AutorMapper.convertToDTO(libro.getAutor()))
                .build();
    }

    public static Libro convertToEntity(LibroDTO libroDTO) {
        return Libro.builder()
                .id(libroDTO.getId())
                .titulo(libroDTO.getTitulo())
                .isbn(libroDTO.getIsbn())
                .disponible(libroDTO.getDisponible())
                .autor(AutorMapper.convertToEntity(libroDTO.getAutor()))
                .build();
    }
}
