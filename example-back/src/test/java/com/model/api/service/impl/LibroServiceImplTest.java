package com.model.api.service.impl;

import com.model.api.service.impl.dto.LibroDTO;
import com.model.api.service.impl.exceptions.ResourceNotFoundException;
import com.model.api.service.impl.model.Libro;
import com.model.api.service.impl.repository.LibroRepository;
import com.model.api.service.impl.service.impl.LibroServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibroServiceImplTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServiceImpl libroService;



    @Test
    void obtenerLibroPorId_deberiaLanzarExcepcionSiNoExiste() {
        Long id = 1L;
        when(libroRepository.findById(id)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> libroService.obtenerLibroPorId(id)
        );

        assertEquals("Libro no encontrado", exception.getMessage());
        verify(libroRepository, times(1)).findById(id);
    }

    @Test
    void actualizarLibro_deberiaLanzarExcepcionSiNoExiste() {
        Long id = 1L;
        LibroDTO libroDTO = LibroDTO.builder().titulo("Actualizado").build();

        when(libroRepository.findById(id)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> libroService.actualizarLibro(id, libroDTO)
        );

        assertEquals("Libro no encontrado", exception.getMessage());
        verify(libroRepository, times(1)).findById(id);
    }

    @Test
    void eliminarLibro_deberiaEliminarLibroSiExiste() {
        Long id = 1L;

        doNothing().when(libroRepository).deleteById(id);

        libroService.eliminarLibro(id);

        verify(libroRepository, times(1)).deleteById(id);
    }


}
