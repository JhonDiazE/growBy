package com.model.api.service.impl.mapper;

import com.model.api.service.impl.dto.AutorDTO;
import com.model.api.service.impl.model.Autor;

public class AutorMapper {

    public static AutorDTO convertToDTO(Autor autor) {
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autor.getId());
        autorDTO.setNombre(autor.getNombre());
        autorDTO.setFechaNacimiento(autor.getFechaNacimiento());
        autorDTO.setNacionalidad(autor.getNacionalidad());
        return autorDTO;
    }

    public static Autor convertToEntity(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setId(autorDTO.getId());
        autor.setNombre(autorDTO.getNombre());
        autor.setFechaNacimiento(autorDTO.getFechaNacimiento());
        autor.setNacionalidad(autorDTO.getNacionalidad());
        return autor;
    }
}
