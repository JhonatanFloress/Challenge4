package com.shopall.repository;

import com.shopall.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByDisponible(boolean disponible);
}