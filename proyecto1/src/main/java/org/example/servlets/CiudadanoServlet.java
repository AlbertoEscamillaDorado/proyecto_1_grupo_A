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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ciudadanos = ciudadanoController.listarCiudadanos();
        request.setAttribute("ciudadanos", ciudadanos);
        request.getRequestDispatcher("ciudadanos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombre");
        Long telefono = Long.parseLong(request.getParameter("telefono"));

        ciudadanoController.agregarCiudadano(nombre, telefono);
        ciudadanos = ciudadanoController.listarCiudadanos();
        response.sendRedirect("ciudadanos");
    }

}
