package com.model.api.service.impl.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;

	@Enumerated(EnumType.STRING)
	private EstadoPrestamo estado;

	@ManyToOne
	@JoinColumn(name = "libro_id")
	private Libro libro;

}
