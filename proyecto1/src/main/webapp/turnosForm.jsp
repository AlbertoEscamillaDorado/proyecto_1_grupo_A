<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><Title>Agregar turno</Title></head>
<body>
<h2>Agregar turnos</h2>
<form action="turnos" method="post">
    Descripción del Trámite: <input type="text" name="descripcionTramite" required><br>
    Id del ciudadano: <input type="number" name="ciudadano" required><br>

    <input type="submit" value="Agregar">
</form>
<br><a href="turnos"><input type="button" value="Lista de turnos"></a>
</body>
</html>