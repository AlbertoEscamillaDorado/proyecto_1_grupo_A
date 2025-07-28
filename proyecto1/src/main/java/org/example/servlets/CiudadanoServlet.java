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

    private final CiudadanoController ciudadanoController = new CiudadanoController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //enviar datos a la vista
        //request.setAttribute("nombre", "Brian");

        List<Ciudadano> listaCiudadanos = ciudadanoController.findAll();


        request.setAttribute("listado", listaCiudadanos);

        request.getRequestDispatcher("ciudadanosForm.jsp").forward(request, response);
    }
}
