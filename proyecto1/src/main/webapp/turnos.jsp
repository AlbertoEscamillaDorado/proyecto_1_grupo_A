<%@ page contentType="text/html;meta charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.entities.Turno" %>
<%@ include file="partials/header.jsp" %>
<html>
<head><title></title></head>
<body>
<div>
    <div>
    <h2>Filtro</h2>
    <form action="turnos" method="get">
    <div class="form-container">
        <div>
        <input type="radio" id="enEspera" name="estado" value="EN_ESPERA">
        <label for="enEspera">En espera</label><br>
        <input type="radio" id="yaAtendido" name="estado" value="YA_ATENDIDO">
        <label for="yaAtendido">Ya atendido</label><br>
        </div>

        <div>
            <input type="date" id="fecha" name="fecha" >
            <label for="fecha"></label><br>
        </div>

        <button class="cssbuttons-io" onclick="window.location.href='turnos'">
          <span>
          <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
              <path d="M0 0h24v24H0z" fill="none"></path>
               <path
                    d="M17 2v2h3.007c.548 0 .993.445.993.993v16.014c0 .548-.445.993-.993.993H3.993C3.445 22 3 21.555 3 21.007V4.993C3 4.445 3.445 4 3.993 4H7V2h10zM7 6H5v14h14V6h-2v2H7V6zm2 10v2H7v-2h2zm0-3v2H7v-2h2zm0-3v2H7v-2h2zm6-6H9v2h6V4z"
                       fill="currentColor"
               ></path>
            </svg>
            Filtrar</span>
        </button>
        </div>
    </form>
    </div>
        <div>
    <h2>Lista de Turnos</h2>
    <table border="1" id="customers">
        <tr><th>ID Ciudadano</th><th>Numero de Turno</th><th>Fecha</th><th>Descripción del Trámite</th><th>Estado</th><th>Id Turno</th></tr>
        <%
        List<Turno> turnos = (List<Turno>) request.getAttribute("turnos");
        if (turnos != null) {
        for (Turno t : turnos) {
        %>
        <tr>
            <td><%= t.getCiudadano().getId() %></td>
            <td><%= t.getIdProgresivo() %></td>
            <td><%= t.getFecha() %></td>
            <td><%= t.getDescripcionTramite() %></td>
            <td><%= t.getEstado() %></td>
            <td><%= t.getId() %></td>
        </tr>
        <%
        }
        }
        %>
        </table>
</div>
</div>
</body>
</html>
<%@ include file="partials/footer.jsp" %>