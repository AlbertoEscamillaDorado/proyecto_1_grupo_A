package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entities.Ciudadano;
import org.example.entities.Turno;
import org.example.enums.Estado;

import java.time.LocalDate;
import java.util.List;

public class TurnoJPA {
    public void agregarTurno(Long idProgresivo, LocalDate fecha, String descripcionTramite, Estado estado, Ciudadano ciudadano) {
        EntityManager em = ConfigJPA.getEntityManager();
        em.getTransaction().begin();
        em.persist(new Turno(idProgresivo, fecha, descripcionTramite, estado, ciudadano));
        em.getTransaction().commit();
        em.close();
    }

    // Realiza una consulta SQL para devolver todos los clientes
    public List<Turno> listarTurnos() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            return em.createQuery("FROM Turno", Turno.class).getResultList();
        }
    }

    // Devuelve el cliente que coincide con la id especificada por el usuario
    public Turno consultarTurnos(Long id) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            return em.find(Turno.class, id);
        }

    }

    // Actualiza el cliente con la id especificada por el usuario
    public boolean actualizarEstadoTurno(Long id, Estado estado) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            Turno turno = em.find(Turno.class, id);
            if (turno != null) {
                em.getTransaction().begin();
                turno.setEstado(estado);
                em.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }

    }
}