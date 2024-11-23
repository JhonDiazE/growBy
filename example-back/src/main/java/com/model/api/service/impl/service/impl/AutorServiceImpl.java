package com.model.api.service.impl.service.impl;

import com.model.api.service.impl.exceptions.ResourceNotFoundException;
import com.model.api.service.impl.mapper.AutorMapper;
import com.model.api.service.impl.model.Autor;
import com.model.api.service.impl.repository.AutorRepository;
import com.model.api.service.impl.service.AutorService;
import com.model.api.service.impl.dto.AutorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    @Override
    public AutorDTO crearAutor(AutorDTO autorDTO) {
        Autor autor = AutorMapper.convertToEntity(autorDTO);
        return AutorMapper.convertToDTO(autorRepository.save(autor));
    }

    @Override
    public AutorDTO obtenerAutorPorId(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));
        return AutorMapper.convertToDTO(autor);
    }

    @Override
    public AutorDTO actualizarAutor(Long id, AutorDTO autorDTO) {
        Autor existente = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));
        existente.setNombre(autorDTO.getNombre());
        existente.setNacionalidad(autorDTO.getNacionalidad());
        existente.setFechaNacimiento(autorDTO.getFechaNacimiento());
        return AutorMapper.convertToDTO(autorRepository.save(existente));
    }

    @Override
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public List<AutorDTO> listarTodosLosAutores() {
        return autorRepository.findAll().stream()
                .map(AutorMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
