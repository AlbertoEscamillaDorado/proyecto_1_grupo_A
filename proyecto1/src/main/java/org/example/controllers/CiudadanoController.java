package org.example.controllers;

import org.example.entities.Ciudadano;
import org.example.persistence.CiudadanoJPA;

import java.util.List;

public class CiudadanoController {
    CiudadanoJPA ciudadanoJPA = new CiudadanoJPA();

    public void agregarCiudadano(String nombre, Long telefono) {
        ciudadanoJPA.agregarCiudadano(nombre, telefono);
    }

    public List<Ciudadano> listarCiudadanos() {
        return ciudadanoJPA.listarCiudadanos();
    }

    public Ciudadano consultarCiudadano(Long id) {
        return ciudadanoJPA.consultarCiudadano(id);
    }
}
