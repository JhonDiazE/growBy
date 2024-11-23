package com.model.api.service.impl.service;

import com.model.api.service.impl.dto.PrestamoDTO;

import java.util.List;

public interface PrestamoService {

	PrestamoDTO crearPrestamo(PrestamoDTO prestamoDTO);
	PrestamoDTO obtenerPrestamoPorId(Long id);
	PrestamoDTO actualizarPrestamo(Long id, PrestamoDTO prestamo);
	void eliminarPrestamo(Long id);
	List<PrestamoDTO> listarPrestamosPorLibro(Long libroId);
	List<PrestamoDTO> listarPrestamos();
}