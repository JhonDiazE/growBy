package com.model.api.service.impl.dto;

import com.model.api.service.impl.model.EstadoPrestamo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class PrestamoDTO {

    private Long id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;
    private LibroDTO libro;
}
