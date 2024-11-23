package com.model.api.service.impl.controller;

import com.model.api.service.impl.dto.AutorDTO;
import com.model.api.service.impl.service.AutorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @ApiOperation(value = "Crear un nuevo autor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Autor creado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta")
    })
    @PostMapping
    public ResponseEntity<AutorDTO> crearAutor(@RequestBody AutorDTO autorDTO) {
        return ResponseEntity.ok(autorService.crearAutor(autorDTO));
    }

    @ApiOperation(value = "Obtener un autor por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Autor encontrado"),
            @ApiResponse(code = 404, message = "Autor no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obtenerAutorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.obtenerAutorPorId(id));
    }

    @ApiOperation(value = "Actualizar un autor existente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Autor actualizado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud incorrecta"),
            @ApiResponse(code = 404, message = "Autor no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> actualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        return ResponseEntity.ok(autorService.actualizarAutor(id, autorDTO));
    }

    @ApiOperation(value = "Eliminar un autor por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Autor eliminado correctamente"),
            @ApiResponse(code = 404, message = "Autor no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Listar todos los autores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de autores obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<List<AutorDTO>> listarAutores() {
        return ResponseEntity.ok(autorService.listarTodosLosAutores());
    }
}
