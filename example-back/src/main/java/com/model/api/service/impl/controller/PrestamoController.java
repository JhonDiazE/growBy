package com.model.api.service.impl.controller;

import com.model.api.service.impl.service.PrestamoService;
import com.model.api.service.impl.dto.PrestamoDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

	private final PrestamoService prestamoService;


	@ApiOperation(value = "Crear un nuevo préstamo")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Préstamo creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud incorrecta")
	})
	@PostMapping
	public ResponseEntity<PrestamoDTO> crearPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
		return ResponseEntity.ok(prestamoService.crearPrestamo(prestamoDTO));
	}

	@ApiOperation(value = "Obtener un préstamo por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Préstamo encontrado"),
			@ApiResponse(code = 404, message = "Préstamo no encontrado")
	})
	@GetMapping("/{id}")
	public ResponseEntity<PrestamoDTO> obtenerPrestamoPorId(@PathVariable Long id
	) {
		return ResponseEntity.ok(prestamoService.obtenerPrestamoPorId(id));
	}

	@ApiOperation(value = "Actualizar un préstamo existente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Préstamo actualizado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud incorrecta"),
			@ApiResponse(code = 404, message = "Préstamo no encontrado")
	})
	@PutMapping("/{id}")
	public ResponseEntity<PrestamoDTO> actualizarPrestamo(@PathVariable Long id,
			@RequestBody PrestamoDTO prestamoDTO
	) {
		return ResponseEntity.ok(prestamoService.actualizarPrestamo(id, prestamoDTO));
	}

	@ApiOperation(value = "Eliminar un préstamo por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Préstamo eliminado correctamente"),
			@ApiResponse(code = 404, message = "Préstamo no encontrado")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id) {
		prestamoService.eliminarPrestamo(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Listar todos los préstamos de un libro específico")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de préstamos obtenida correctamente"),
			@ApiResponse(code = 404, message = "Libro no encontrado")
	})
	@GetMapping("/libro/{libroId}")
	public ResponseEntity<List<PrestamoDTO>> listarPrestamosPorLibro(@PathVariable Long libroId
	) {
		return ResponseEntity.ok(prestamoService.listarPrestamosPorLibro(libroId));
	}

	@GetMapping
	public ResponseEntity<List<PrestamoDTO>> listarPrestamo() {
		return ResponseEntity.ok(prestamoService.listarPrestamos());
	}

}
