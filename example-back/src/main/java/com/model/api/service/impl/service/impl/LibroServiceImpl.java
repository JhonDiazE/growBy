package com.model.api.service.impl.service.impl;

import com.model.api.service.impl.exceptions.ResourceNotFoundException;
import com.model.api.service.impl.mapper.AutorMapper;
import com.model.api.service.impl.mapper.LibroMapper;
import com.model.api.service.impl.model.Libro;
import com.model.api.service.impl.repository.LibroRepository;
import com.model.api.service.impl.service.LibroService;
import com.model.api.service.impl.dto.LibroDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO) {
        Libro libro = LibroMapper.convertToEntity(libroDTO);
        return LibroMapper.convertToDTO(libroRepository.save(libro));
    }

    @Override
    public LibroDTO obtenerLibroPorId(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado"));
        return LibroMapper.convertToDTO(libro);
    }

    @Override
    public LibroDTO actualizarLibro(Long id, LibroDTO libroDTO) {
        Libro existente = libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado"));
        existente.setTitulo(libroDTO.getTitulo());
        existente.setAutor(AutorMapper.convertToEntity(libroDTO.getAutor()));
        return LibroMapper.convertToDTO(libroRepository.save(existente));
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public List<LibroDTO> listarTodosLosLibros() {
        return libroRepository.findAll().stream()
                .map(LibroMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
