<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ include file="partials/header.jsp" %>
<%@ page import="org.example.entities.Turno" %>
<html lang="en">
<head><title>Gestionar turnos</title></head>
<body>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% if (errorMessage != null) { %>
<script>
    alert("<%= errorMessage %>");
</script>
<% } %>
<h2>Turno a gestionar</h2>
<form action="gestionarEstado" method="post">
    <div class="form-container">
    <div>
        <label for="turno">ID del turno: </label>
        <input type="text" id="turno" name="turno" required>
    </div>
    <div>
        <input type="radio" id="enEspera" name="estado" value="EN_ESPERA" required>
        <label for="enEspera">En espera</label><br>
        <input type="radio" id="yaAtendido" name="estado" value="YA_ATENDIDO" required>
        <label for="yaAtendido">Ya atendido</label><br>
    </div>
    <button type="submit" class="cssbuttons-io">
          <span>
          <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
              <path d="M0 0h24v24H0z" fill="none"></path>
               <path
                       d="M7 7V3a1 1 0 0 1 1-1h13a1 1 0 0 1 1 1v13a1 1 0 0 1-1 1h-4v3.993c0 .556-.449 1.007-1.007 1.007H3.007A1.006 1.006 0 0 1 2 20.993l.003-12.986C2.003 7.451 2.452 7 3.01 7H7zm2 0h6.993C16.549 7 17 7.449 17 8.007V15h3V4H9v3zm6 2H4.003L4 20h11V9zm-6.497 9l-3.536-3.536 1.414-1.414 2.122 2.122 4.242-4.243 1.414 1.414L8.503 18z"
                       fill="currentColor"
               ></path>
            </svg>
            Actualizar estado</span>
    </button>
    </div>
</form>

<table border="1" id="customers">
    <tr>
        <th>ID Ciudadano</th>
        <th>Numero de Turno</th>
        <th>Fecha</th>
        <th>Descripción del Trámite</th>
        <th>Estado</th>
        <th>ID Turno</th>
    </tr>
    <%
    List
    <Turno> turnos = (List
        <Turno>) request.getAttribute("turnos");
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
<br>
</body>
</html>
<%@ include file="partials/footer.jsp" %>
