package org.example.controllers;

import org.example.entities.Ciudadano;
import org.example.entities.Turno;
import org.example.enums.Estado;
import org.example.persistence.TurnoJPA;

import java.time.LocalDate;
import java.util.List;

public class TurnoController {
    TurnoJPA turnoJPA = new TurnoJPA();

    public void agregarTurno(Long idProgresivo, LocalDate fecha, String descripcionTramite, Estado estado, Ciudadano ciudadano) {
        turnoJPA.agregarTurno(idProgresivo, fecha, descripcionTramite, estado, ciudadano);
    }

    public List<Turno> listarTurnos() {
        return turnoJPA.listarTurnos();
    }

    public Turno consultarTurno(Long id) {
        return turnoJPA.consultarTurnos(id);
    }

    public boolean actualizarEstadoTurno(Long id, Estado estado) {
        return turnoJPA.actualizarEstadoTurno(id, estado);
    }
}
