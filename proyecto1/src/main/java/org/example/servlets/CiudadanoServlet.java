package org.example.servlets;

import org.example.controllers.CiudadanoController;
import org.example.entities.Ciudadano;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ciudadanos")
public class CiudadanoServlet extends HttpServlet {
    private List<Ciudadano> ciudadanos = new ArrayList<>();

    private final CiudadanoController ciudadanoController = new CiudadanoController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;

        Ciudadano ciudadanoEncontrado = new Ciudadano();
        ciudadanoEncontrado.setId(id);

        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                id = Long.parseLong(idParam);
                System.out.println("--------- "+ id);
                // busco el ciudadano
                ciudadanoEncontrado =  ciudadanoController.consultarCiudadano(id);
            } catch (NumberFormatException e) {
                System.err.println("Valor no valido");
            }
        }

        request.setAttribute("id", ciudadanoEncontrado.getId());
        request.setAttribute("nombre", ciudadanoEncontrado.getNombre());
        request.setAttribute("teléfono", ciudadanoEncontrado.getTelefono());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Long telefono = Long.parseLong(request.getParameter("telefono"));

        ciudadanoController.agregarCiudadano(nombre, telefono);
        ciudadanos = ciudadanoController.listarCiudadanos();
        request.setAttribute("ciudadanos", ciudadanos);
        request.getRequestDispatcher("ciudadanos.jsp").forward(request, response);
    }

}
