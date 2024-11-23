package com.model.api.service.impl.mapper;

import com.model.api.service.impl.dto.LibroDTO;
import com.model.api.service.impl.dto.PrestamoDTO;
import com.model.api.service.impl.model.Libro;
import com.model.api.service.impl.model.Prestamo;

import java.util.Objects;

public class PrestamoMapper {

    public static PrestamoDTO convertToDTO(Prestamo prestamo) {
        LibroDTO libroDTO = null;
        if (Objects.nonNull(prestamo.getLibro())) {
            libroDTO = LibroDTO.builder()
                    .id(prestamo.getLibro().getId())
                    .titulo(prestamo.getLibro().getTitulo())
                    .build();
        }

        return PrestamoDTO.builder()
                .id(prestamo.getId())
                .fechaPrestamo(prestamo.getFechaPrestamo())
                .estado(prestamo.getEstado())
                .fechaDevolucion(prestamo.getFechaDevolucion())
                .libro(libroDTO)
                .build();
    }

    public static Prestamo convertToEntity(PrestamoDTO prestamoDTO) {
        Libro libro = null;
        if (Objects.nonNull(prestamoDTO.getLibro())) {
            libro = Libro.builder()
                    .id(prestamoDTO.getLibro().getId())
                    .titulo(prestamoDTO.getLibro().getTitulo())
                    .build();
        }

        return Prestamo.builder()
                .id(prestamoDTO.getId())
                .fechaPrestamo(prestamoDTO.getFechaPrestamo())
                .estado(prestamoDTO.getEstado())
                .fechaDevolucion(prestamoDTO.getFechaDevolucion())
                .libro(libro)
                .build();
    }
}
