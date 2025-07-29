<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.entities.Turno" %>
<html>
<head><title></title></head>
<body>
<h2>Lista de Turnos</h2>
<table border="1">
    <tr><th>Id</th><th>Numero de Turno</th><th>Fecha</th><th>Descripción del Trámite</th><th>Estado</th><th>Ciudadano</th></tr>
    <%
    List<Turno> turnos = (List<Turno>) request.getAttribute("turnos");
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
<br><a href="index.jsp">Página Principal</a>
</body>
</html>