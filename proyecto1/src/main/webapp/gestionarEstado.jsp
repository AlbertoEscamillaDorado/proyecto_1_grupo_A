<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
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
    Id del turno: <input type="number" name="turno" required><br>
    <div>
        <input type="radio" id="enEspera" name="estado" value="EN_ESPERA" required>
        <label for="enEspera">En espera</label><br>
        <input type="radio" id="yaAtendido" name="estado" value="YA_ATENDIDO" required>
        <label for="yaAtendido">Ya atendido</label><br>
    </div>

    <input type="submit" value="Actualizar turno">
</form>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Numero de Turno</th>
        <th>Fecha</th>
        <th>Descripción del Trámite</th>
        <th>Estado</th>
        <th>Ciudadano</th>
    </tr>
    <%
    List
    <Turno> turnos = (List
        <Turno>) request.getAttribute("turnos");
            if (turnos != null) {
            for (Turno t : turnos) {
            %>
            <tr>
                <td><%= t.getId() %></td>
                <td><%= t.getIdProgresivo() %></td>
                <td><%= t.getFecha() %></td>
                <td><%= t.getDescripcionTramite() %></td>
                <td><%= t.getEstado() %></td>
                <td><%= t.getCiudadano().getId() %></td>

            </tr>
            <%
            }
            }
            %>
</table>
<br>
<a href="index.jsp">
    <input type="button" value="Volver a la página principal">
</a>
</body>
</html>