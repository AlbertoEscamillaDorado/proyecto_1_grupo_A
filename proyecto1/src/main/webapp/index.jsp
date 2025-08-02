<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="partials/header.jsp" %>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
  <title>Registro</title>
</head>
<body>
<h2>Elija una acción</h2>
<div class="contenedor">
<button class="cssbuttons-io" onclick="window.location.href='ciudadanosForm.jsp'">
  <span
  ><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
      <path d="M0 0h24v24H0z" fill="none"></path>
      <path
              d="M11 11V7h2v4h4v2h-4v4h-2v-4H7v-2h4zm1 11C6.477 22 2 17.523 2 12S6.477 2 12 2s10 4.477 10 10-4.477 10-10 10zm0-2a8 8 0 1 0 0-16 8 8 0 0 0 0 16z"
              fill="currentColor"
      ></path>
    </svg>
    Agregar un ciudadano</span
  >
</button>

<button class="cssbuttons-io" onclick="window.location.href='turnosForm.jsp'">
  <span
  ><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
      <path d="M0 0h24v24H0z" fill="none"></path>
       <path
               d="M11 11V7h2v4h4v2h-4v4h-2v-4H7v-2h4zm1 11C6.477 22 2 17.523 2 12S6.477 2 12 2s10 4.477 10 10-4.477 10-10 10zm0-2a8 8 0 1 0 0-16 8 8 0 0 0 0 16z"
               fill="currentColor"
       ></path>
    </svg>
    Agregar un turno</span
  >
</button>

<button class="cssbuttons-io" onclick="window.location.href='gestionarEstado'">
  <span
  ><svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
      <path d="M0 0h24v24H0z" fill="none"></path>
      <path
              d="M5 19h1.414l9.314-9.314-1.414-1.414L5 17.586V19zm16 2H3v-4.243L16.435 3.322a1 1 0 0 1 1.414 0l2.829 2.829a1 1 0 0 1 0 1.414L9.243 19H21v2zM15.728 6.858l1.414 1.414 1.414-1.414-1.414-1.414-1.414 1.414z"
              fill="currentColor"
      ></path>
    </svg>
    Atender un turno</span
  >
</button>
</div>
</body>
</html>
<%@ include file="partials/footer.jsp" %>