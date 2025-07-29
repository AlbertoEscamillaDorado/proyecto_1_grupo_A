<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><Title>Agregar ciudadano</Title></head>
<body>
<h2>Agregar ciudadano a la lista de turnos</h2>
<form action="agregar" method="post">
    Nombre: <input type="text" name="nombre" required><br>
    Teléfono: <input type="number" name="telefono" required><br>

    <input type="submit" value="Agregar">
</form>
</body>
</html>
