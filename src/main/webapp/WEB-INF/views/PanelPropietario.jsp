<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel propietario</title>
</head>
<body>
<h1>Bienvenido <c:out value="${usuario}"/></h1>
	
	<a href="PisosPropietario">Ver mis pisos</a><br>
	<a href="CrearPiso">Insertar un piso</a><br>
	<a href="CerrarSesion">Cerrar sesion</a>

</body>
</html>