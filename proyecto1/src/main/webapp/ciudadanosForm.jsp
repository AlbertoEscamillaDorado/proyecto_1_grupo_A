<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="partials/header.jsp" %>
<html>
<head><Title>Agregar ciudadano</Title></head>
<h2>Agregar ciudadano a la lista de turnos</h2>

<div class="form-container">
      <form class="form" action="ciudadanos" method="post">
        <div class="form-group">
          <label for="nombre">Introduzca su nombre</label>
          <input type="text" id="nombre" name="nombre" required>
        </div>
        <div class="form-group">
          <label for="telefono">Introduzca su número de teléfono</label>
          <input type="text" id="telefono" name="telefono" required>
        </div>
        <button type="submit" class="cssbuttons-io">
          <span>
          <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
              <path d="M0 0h24v24H0z" fill="none"></path>
               <path
                       d="M11 11V7h2v4h4v2h-4v4h-2v-4H7v-2h4zm1 11C6.477 22 2 17.523 2 12S6.477 2 12 2s10 4.477 10 10-4.477 10-10 10zm0-2a8 8 0 1 0 0-16 8 8 0 0 0 0 16z"
                       fill="currentColor"
               ></path>
            </svg>
            Agregar </span>
        </button>
</form>
<button class="cssbuttons-io" onclick="window.location.href='ciudadanos'">
  <span>
  <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
      <path d="M0 0h24v24H0z" fill="none"></path>
       <path
            d="M17 2v2h3.007c.548 0 .993.445.993.993v16.014c0 .548-.445.993-.993.993H3.993C3.445 22 3 21.555 3 21.007V4.993C3 4.445 3.445 4 3.993 4H7V2h10zM7 6H5v14h14V6h-2v2H7V6zm2 10v2H7v-2h2zm0-3v2H7v-2h2zm0-3v2H7v-2h2zm6-6H9v2h6V4z"
               fill="currentColor"
       ></path>
    </svg>
    Lista de Ciudadanos</span>
</button>
</div>
</body>
</html>
<%@ include file="partials/footer.jsp" %>

