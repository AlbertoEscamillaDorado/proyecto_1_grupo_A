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
    <%
    Long id = (Long) request.getAttribute("id");
    String nombre = (String) request.getAttribute("nombre");
    Long telefono = (Long) request.gerAttribute("telefono");

    String titulo = "Crear";

    if(id != 0L){
    titulo = "Modificar";
    }
    %>
    <h1><%= titulo %> Ciudadano</h1>
    <form class="formulario-ciudadano" action="/app/ciudadanosForm" method="POST">
        <div class="campo-form">
            <input type="hidden" id="id" name="id" value="<%=id%>" />
        </div>
        <div class="campo-form">
            <label for="nombre">Nombre</label>
            <input type="text" id="nombre" name="nombre" value="<%=nombre%>" required />
        </div>

        <div class="botones-formulario">
            <button type="reset" class="btn-blanco">Limpiar</button>
            <button type="submit" class="btn-azul"><%= titulo %></button>
        </div>
    </form>
</main>
</body>
</html>
