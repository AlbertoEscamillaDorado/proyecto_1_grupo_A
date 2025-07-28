package com.example.servlets;

import com.example.controllers.CiudadanoController;
import com.example.entities.Ciudadano;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ciudadanosForm")
public class CiudadanoFormServlet extends HttpServlet {

    private final CiudadanoController ciudadanoController = new CiudadanoController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;
        Ciudadano ciudadanoEncontrado = new Ciudadano();
        ciudadanoEncontrado.setId(id);
        ciudadanoEncontrado.setNombre("");
        ciudadanoEncontrado.setTelefono("")

        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                id = Long.parseLong(idParam);
                System.out.println("--------- "+ id);
                // busco el ciudadano
                ciudadanoEncontrado =  ciudadanoController.findOne(id);
            } catch (NumberFormatException e) {
                System.err.println("Valor no valido");
            }
        }

        request.setAttribute("id", ciudadanoEncontrado.getId());
        request.setAttribute("nombre", ciudadanoEncontrado.getNombre());
        request.setAttribute("teléfono" ciudadanoEncontrado.getTelefono());

        request.getRequestDispatcher("ciudadanosForm.jsp").forward(request, response);
    }

    //ruta de tipo POST

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //capturar la info del form nombre, apellido, edad, email
        Long id = Long.parseLong(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        if(id != 0L){
            System.out.println("UPDATE");
            System.out.println(id);
            System.out.println(nombre);
            System.out.println(apellido);
            ciudadanoController.update(id, nombre, apellido);
        }else{
            ciudadanoController.create(nombre, apellido);
        }

        resp.sendRedirect("/app/ciudadanos");
    }
}
