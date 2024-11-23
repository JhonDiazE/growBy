package com.model.api.service.impl.controller;

import com.model.api.service.impl.dto.LibroDTO;
import com.model.api.service.impl.service.LibroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @ApiOperation(value = "Crear un nuevo libro")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Libro creado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta")
    })
    @PostMapping
    public ResponseEntity<LibroDTO> crearLibro(@RequestBody LibroDTO libroDTO) {
        return ResponseEntity.ok(libroService.crearLibro(libroDTO));
    }

    @ApiOperation(value = "Obtener un libro por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Libro encontrado"),
            @ApiResponse(code = 404, message = "Libro no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obtenerLibroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.obtenerLibroPorId(id));
    }

    @ApiOperation(value = "Actualizar un libro existente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Libro actualizado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta"),
            @ApiResponse(code = 404, message = "Libro no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        return ResponseEntity.ok(libroService.actualizarLibro(id, libroDTO));
    }

    @ApiOperation(value = "Eliminar un libro por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Libro eliminado correctamente"),
            @ApiResponse(code = 404, message = "Libro no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Listar todos los libros")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de libros obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<List<LibroDTO>> listarLibros() {
        return ResponseEntity.ok(libroService.listarTodosLosLibros());
    }
}
