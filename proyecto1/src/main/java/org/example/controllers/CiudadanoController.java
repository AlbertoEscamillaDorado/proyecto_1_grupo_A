package org.example.controllers;

import org.example.entities.Ciudadano;
import org.example.persistence.CiudadanoJPA;

import java.util.List;

public class CiudadanoController {
    CiudadanoJPA ciudadanoJPA = new CiudadanoJPA();

    public void agregarCiudadano(String nombre, int telefono) {
        ciudadanoJPA.agregarCiudadano(nombre,telefono);
    }

    public List<Ciudadano> listarCiudadanos() {
        return ciudadanoJPA.listarCiudadanos();
    }

    public Ciudadano consultarCiudadano(Long id) {
        return ciudadanoJPA.consultarCiudadano(id);
    }

    //Metodo para que no haya respuestas vacías
    /*private Type<T> leerNoVacio() {
        String entrada = scanner.nextLine();
        while (entrada.isBlank()) {
            System.out.print("Este campo es obligatorio. Ingrese de nuevo: ");
            entrada = scanner.nextLine();
        }
        return entrada;
    }*/

}
