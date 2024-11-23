package com.model.api.service.impl.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.model.api.service.impl.exceptions.ResourceNotFoundException;
import com.model.api.service.impl.mapper.PrestamoMapper;
import com.model.api.service.impl.model.Prestamo;
import com.model.api.service.impl.repository.PrestamoRepository;
import com.model.api.service.impl.service.PrestamoService;
import com.model.api.service.impl.dto.PrestamoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {

	private final PrestamoRepository prestamoRepository;


	public PrestamoDTO crearPrestamo(PrestamoDTO prestamoDTO) {
		Prestamo prestamo = PrestamoMapper.convertToEntity(prestamoDTO);
		return PrestamoMapper.convertToDTO(prestamoRepository.save(prestamo));
	}

	public PrestamoDTO obtenerPrestamoPorId(Long id) {
		Prestamo prestamo = prestamoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Préstamo no encontrado"));
		return PrestamoMapper.convertToDTO(prestamo);
	}

	public PrestamoDTO actualizarPrestamo(Long id, PrestamoDTO prestamo) {
		Prestamo existente = prestamoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Préstamo no encontrado"));
		existente.setFechaDevolucion(prestamo.getFechaDevolucion());
		existente.setEstado(prestamo.getEstado());
		return PrestamoMapper.convertToDTO(prestamoRepository.save(existente));
	}

	public void eliminarPrestamo(Long id) {
		prestamoRepository.deleteById(id);
	}

	public List<PrestamoDTO> listarPrestamosPorLibro(Long libroId) {
		return prestamoRepository.findByLibroId(libroId).stream()
				.map(PrestamoMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<PrestamoDTO> listarPrestamos() {
		return prestamoRepository.findAll().stream()
				.map(PrestamoMapper::convertToDTO)
				.collect(Collectors.toList());
	}
}
