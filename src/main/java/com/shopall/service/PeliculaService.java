package com.shopall.service;

import com.shopall.model.Pelicula;
import com.shopall.repository.PeliculaRepository;
import com.shopall.exception.PeliculaNoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> obtenerTodas() {
        return peliculaRepository.findAll();
    }

    public List<Pelicula> obtenerDisponibles() {
        return peliculaRepository.findByDisponible(true);
    }

    public List<Pelicula> obtenerNoDisponibles() {
        return peliculaRepository.findByDisponible(false);
    }

    public Pelicula agregar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void eliminar(int id) {
        if (!peliculaRepository.existsById(id)) {
            throw new PeliculaNoEncontradaException("Película con ID " + id + " no encontrada");
        }
        peliculaRepository.deleteById(id);
    }

    public Pelicula marcarComoDisponible(int id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new PeliculaNoEncontradaException("Película con ID " + id + " no encontrada"));
        pelicula.setDisponible(true);
        return peliculaRepository.save(pelicula);
    }
}