package com.model.api.service.impl.repository;


import com.model.api.service.impl.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
