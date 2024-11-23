package com.model.api.service.impl.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AutorDTO {

    private Long id;
    private String nombre;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
}
