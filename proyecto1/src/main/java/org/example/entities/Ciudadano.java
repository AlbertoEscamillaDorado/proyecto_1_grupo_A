package org.example.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciudadanos")
public class Ciudadano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long telefono;
    @OneToMany(mappedBy = "ciudadano", cascade = CascadeType.ALL)
    private List<Turno> turnos = new ArrayList<>();

    public Ciudadano() {
    }

    public Ciudadano(String nombre, Long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void addTurno(Turno turno) {
        this.turnos.add(turno);
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "id: " + id +
                ", nombre: '" + nombre + '\'' +
                ", telefono: " + telefono +
                '}';
    }
}
