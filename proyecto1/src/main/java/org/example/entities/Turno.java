package org.example.entities;

import jakarta.persistence.*;
import org.example.enums.Estado;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;

@Entity
@Table (name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProgresivo;
    private LocalDate fecha;
    private String descripcionTramite;
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "ciudadanoId")
    private Ciudadano ciudadano;

    public Turno() {}

    public Turno(Long idProgresivo, LocalDate fecha, String descripcionTramite, Estado estado, Ciudadano ciudadano) {
        this.idProgresivo = idProgresivo;
        this.fecha = fecha;
        this.descripcionTramite = descripcionTramite;
        this.estado = estado;
        this.ciudadano = ciudadano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProgresivo() {
        return idProgresivo;
    }

    public void setIdProgresivo(Long idProgresivo) {
        this.idProgresivo = idProgresivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionTramite() {
        return descripcionTramite;
    }

    public void setDescripcionTramite(String descripcionTramite) {
        this.descripcionTramite = descripcionTramite;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id: " + id +
                ", idProgresivo: " + idProgresivo +
                ", fecha: " + fecha +
                ", descripcionTramite: '" + descripcionTramite + '\'' +
                ", estado: " + estado +
                ", ciudadano: " + ciudadano.getId() +
                '}';
    }
}
