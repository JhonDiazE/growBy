package com.model.api.service.impl.repository;



import com.model.api.service.impl.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
	List<Prestamo> findByLibroId(Long libroId);
}