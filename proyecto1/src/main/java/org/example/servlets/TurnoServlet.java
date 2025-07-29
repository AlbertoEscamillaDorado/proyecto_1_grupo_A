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
import java.util.List;

@WebServlet(urlPatterns = "/turnos")
public class TurnoServlet extends HttpServlet {
    private List<Turno> turnos = new ArrayList<>();

    private final TurnoController turnoController = new TurnoController();
    private final CiudadanoController ciudadanoController = new CiudadanoController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;
        
        Turno turnoEncontrado = new Turno();
        turnoEncontrado.setId(id);
        //turnoEncontrado.setIdProgresivo(GenerarIdProgresivo.generarIdProgresivo());
        //turnoEncontrado.setFecha(LocalDate.now());
        //turnoEncontrado.setDescripcionTramite("");
        //turnoEncontrado.setEstado(Estado.EN_ESPERA);
        //turnoEncontrado.setCiudadano(new Ciudadano());


        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                id = Long.parseLong(idParam);
                System.out.println("--------- "+ id);
                // busco el turno
                turnoEncontrado =  turnoController.consultarTurno(id);
            } catch (NumberFormatException e) {
                System.err.println("Valor no valido");
            }
        }

        request.setAttribute("id", turnoEncontrado.getId());
        //request.setAttribute("nombre", turnoEncontrado.getNombre());
        //request.setAttribute("teléfono", turnoEncontrado.getTelefono());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long idProgresivo = GenerarIdProgresivo.generarIdProgresivo();
        LocalDate fecha = LocalDate.now();
        String descripcionTramite = request.getParameter("descripcionTramite");
        Estado estado = Estado.EN_ESPERA;
        Ciudadano ciudadano = ciudadanoController.consultarCiudadano(Long.valueOf(request.getParameter("ciudadano")));

        turnoController.agregarTurno(idProgresivo, fecha,descripcionTramite,estado,ciudadano);
        turnos = turnoController.listarTurnos();
        request.setAttribute("turnos", turnos);
        request.getRequestDispatcher("turnos.jsp").forward(request, response);
    }

}
