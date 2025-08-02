package org.example.servlets;

import org.example.controllers.TurnoController;
import org.example.entities.Turno;
import org.example.enums.Estado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/gestionarEstado")
public class GestionarEstadoServlet extends HttpServlet {

    private List<Turno> turnos = new ArrayList<>();
    private final TurnoController turnoController = new TurnoController();

    // Mostrar los datos de un turno
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sirve para mostrar/guardar los caracteres especiales de la base de datos
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        turnos = turnoController.listarTurnos();
        request.setAttribute("turnos", turnos);
        request.getRequestDispatcher("gestionarEstado.jsp").forward(request, response);
    }

    // Recoger los datos de un turno y lo añade a la BBDD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Long idTurno = Long.valueOf(request.getParameter("turno"));
        Estado estado = Estado.valueOf(request.getParameter("estado"));

        if (turnoController.consultarTurno(idTurno) != null) {
            turnoController.actualizarEstadoTurno(idTurno, estado);
            response.sendRedirect("gestionarEstado");
        } else {
            request.setAttribute("errorMessage", "El ID de turno " + idTurno + " no existe.");

            List<Turno> turnos = turnoController.listarTurnos();
            request.setAttribute("turnos", turnos);
            request.getRequestDispatcher("gestionarEstado.jsp").forward(request, response);
        }
    }
}