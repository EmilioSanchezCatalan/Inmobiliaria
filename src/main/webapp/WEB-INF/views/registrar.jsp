<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrarse</title>
</head>
<body>
	<h2>Registrarse como:</h2>
	<form action="Registro" method ="POST">
		<input type="radio" name="registrar" value = "alumno"/>Alumno<br/>
		<input type="radio" name="registrar" value = "propietario"/>Propietario<br/>
		<input type="submit" value="Siguiente">
	</form>
</body>
</html>