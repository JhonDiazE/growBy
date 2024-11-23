package com.model.api.service.impl.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LibroDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private Boolean disponible;
    private AutorDTO autor;
}
