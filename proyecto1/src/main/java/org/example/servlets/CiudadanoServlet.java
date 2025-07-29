package com.example.servlets;

import com.example.controllers.CiudadanoController;
import com.example.entities.Ciudadano;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(urlPatterns = "/crearciudadanos")
public class CiudadanoServlet extends HttpServlet {
    private List<Ciudadano> ciudadanos = new ArrayList<>();

    private final CiudadanoController ciudadanoController = new CiudadanoController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Long telefono = Long.parseLong(request.getParameter("telefono"));

        ciudadanos.add(new Ciudadano(nombre,telefono));
        ciudadanoController.agregarCiudadano(nombre, telefono);


        request.setAttribute("ciudadanos", ciudadanos);

        request.getRequestDispatcher("ciudadanosForm.jsp").forward(request, response);
    }
}
