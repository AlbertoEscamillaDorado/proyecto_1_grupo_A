package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entities.Ciudadano;
import org.example.entities.Turno;
import org.example.enums.Estado;

import java.time.LocalDate;
import java.util.List;

public class CiudadanoJPA {
    public void agregarCiudadano(String nombre, int telefono) {
        EntityManager em = ConfigJPA.getEntityManager();
        em.getTransaction().begin();
        em.persist(new Ciudadano(nombre,telefono));
        em.getTransaction().commit();
        em.close();
    }

    // Realiza una consulta SQL para devolver todos los clientes
    public List<Ciudadano> listarCiudadanos() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            return em.createQuery("FROM Ciudadano", Ciudadano.class).getResultList();
        }
    }

    // Devuelve el cliente que coincide con la id especificada por el usuario
    public Ciudadano consultarCiudadano(Long id) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            return em.find(Ciudadano.class, id);
        }
    }
}
