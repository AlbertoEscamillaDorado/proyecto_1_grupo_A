<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><Title>Agregar ciudadano</Title></head>
<h2>Agregar ciudadano a la lista de turnos</h2>
<form action="ciudadanos" method="post">
    Nombre: <input type="text" name="nombre" required><br>
    Teléfono: <input type="number" name="telefono" required><br>

    <input type="submit" value="Agregar">
</form>
<br>
<a href="ciudadanos">
    <input type="button" value="Lista de ciudadanos">
</a>
<br>
<a href="index.jsp">
    <input type="button" value="Volver a la página principal">
</a>
</body>
</html>
