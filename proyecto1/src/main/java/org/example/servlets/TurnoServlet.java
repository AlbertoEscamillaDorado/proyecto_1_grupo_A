package org.example.servlets;

import org.example.controllers.CiudadanoController;
import org.example.controllers.TurnoController;
import org.example.entities.Ciudadano;
import org.example.entities.Turno;
import org.example.enums.Estado;
import org.example.utils.GenerarIdProgresivo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/turnos")
public class TurnoServlet extends HttpServlet {
    private List<Turno> turnos = new ArrayList<>();

    private final TurnoController turnoController = new TurnoController();
    private final CiudadanoController ciudadanoController = new CiudadanoController();
    // mostrar los datos de un turno
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;
        Turno turnoEncontrado = new Turno();
        turnos = turnoController.listarTurnos();

        String fechaParam = request.getParameter("fecha");
        String estadoParam = request.getParameter("estado");

        List<Turno> turnosFiltrados = turnos.stream()
                // Filtra por fecha si no es nula ni vacía
                .filter(v -> fechaParam == null || fechaParam.isEmpty() || v.getFecha().equals(LocalDate.parse(fechaParam)))
                // Filtra por estado si no es nulo ni vacío
                .filter(v -> estadoParam == null || estadoParam.isEmpty() || v.getEstado().equals(Estado.valueOf(estadoParam)))
                .sorted(Comparator.comparing(Turno::getIdProgresivo))
                .collect(Collectors.toList());

        request.setAttribute("turnos", turnosFiltrados);
        request.getRequestDispatcher("turnos.jsp").forward(request, response);
    }
    // recoger los datos de un turno y lo añade a la BBDD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long idProgresivo = GenerarIdProgresivo.generarIdProgresivo();
        LocalDate fecha = LocalDate.now();
        String descripcionTramite = request.getParameter("descripcionTramite");
        Estado estado = Estado.EN_ESPERA;
        Ciudadano ciudadano = ciudadanoController.consultarCiudadano(Long.valueOf(request.getParameter("ciudadano")));

        if (ciudadano != null) {
            turnoController.agregarTurno(idProgresivo, fecha, descripcionTramite, estado, ciudadano);
        }
        turnos = turnoController.listarTurnos();
        request.setAttribute("turnos", turnos);
        request.getRequestDispatcher("turnos.jsp").forward(request, response);
        response.sendRedirect("index.jsp");

    }

}
