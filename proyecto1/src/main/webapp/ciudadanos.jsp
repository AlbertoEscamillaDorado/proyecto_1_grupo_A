<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.entities.Ciudadano" %>
<html>
<head><title>L</title></head>
<body>
<h2>Lista del supermercado</h2>
<table border="1">
    <tr><th>Nombre</th><th>Cantidad</th><th>Precio</th></tr>
    <%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    if (productos != null) {
    for (Producto p : productos) {
    %>
    <tr>
        <td><%= p.getNombre() %></td>
        <td><%= p.getCantidad() %></td>
        <td>$<%= p.getPrecio() %></td>
    </tr>
    <%
    }
    }
    %>
</table>
<br><a href="index.jsp">Agregar otro producto</a>
</body>
</html>







