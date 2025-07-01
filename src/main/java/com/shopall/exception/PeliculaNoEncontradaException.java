package com.shopall.exception;

public class PeliculaNoEncontradaException extends RuntimeException {
    public PeliculaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}