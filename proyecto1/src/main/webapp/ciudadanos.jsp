<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.example.entities.Persona, com.example.entities.Tarjeta, com.example.entities.Producto" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header Facebook Emulado</title>
    <link rel="stylesheet" href="public/css/style.css">
</head>
<body>
<%@ include file="partials/header.jsp" %>
<!-- contenido principal -->
<main class="contenido-principal">
    <h1>Lista de Personas</h1>
    <table class="tabla-personas">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Tarjetas</th>
            <th>Productos</th>
            <th>Modifica</th>
        </tr>
        </thead>
        <tbody>
        <%   List<Persona> listado = (List<Persona>) request.getAttribute("listado");
            for (Persona persona: listado) { %>
            <tr>
                <td> <%= persona.getNombre() %> </td>
                <td> <%= persona.getApellido() %> </td>
                <td>
                    <% for(Tarjeta tarjeta: persona.getTarjetas()){ %>
                    <span class="tarjetas"> <%= tarjeta.getTipo() %> - </span>
                    <% } %>

                </td>
                <td>
                    <% for(Producto producto: persona.getProductos()){ %>
                    <span class="productos"> <%= producto.getNombre() %> - </span>
                    <% } %>
                </td>
                <td>
                    <% String urlPersona = "/app/personasForm?id=" + persona.getId(); %>
                    <a href=<%= urlPersona %>>✍️</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% if(listado.isEmpty()) {%>
    <i>No hay personas en la lista con la palabra : <%= request.getAttribute("nombre") %></i>
    <% } %>
</main>
</body>
</html>







