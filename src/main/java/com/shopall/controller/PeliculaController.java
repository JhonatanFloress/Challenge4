package com.shopall.controller;

import com.shopall.model.Pelicula;
import com.shopall.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelicula> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/disponibles")
    public List<Pelicula> obtenerDisponibles() {
        return service.obtenerDisponibles();
    }

    @GetMapping("/nodisponibles")
    public List<Pelicula> obtenerNoDisponibles() {
        return service.obtenerNoDisponibles();
    }

    @PostMapping
    public Pelicula agregar(@Valid @RequestBody Pelicula pelicula) {
        return service.agregar(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @PutMapping("/{id}/disponible")
    public Pelicula marcarComoDisponible(@PathVariable int id) {
        return service.marcarComoDisponible(id);
    }
}