<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.entities.Ciudadano" %>
<html>
<head><title></title></head>
<body>
<h2>Lista de Ciudadanos</h2>
<table border="1">
    <tr><th>Id</th><th>Nombre</th><th>Telefono</th></tr>
    <%
    List<Ciudadano> ciudadanos = (List<Ciudadano>) request.getAttribute("ciudadanos");
    if (ciudadanos != null) {
    for (Ciudadano c : ciudadanos) {
    %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getNombre() %></td>
        <td><%= c.getTelefono() %></td>

    </tr>
    <%
    }
    }
    %>
</table>
<br><a href="index.jsp">Agregar otro ciudadano</a>
</body>
</html>







