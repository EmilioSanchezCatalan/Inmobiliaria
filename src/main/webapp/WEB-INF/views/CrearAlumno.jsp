<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inuja</title>
</head>
<body>
	Rellene los siguientes datos:
	<form action="alumno" method="post">

		DNI: <input type="text" name="dni"><br>
		Nombre: <input type="text" name="nombre"><br>
		Apellidos:<input type="text" name="apellidos"><br>
		Fecha de nacimiento(dd/mm/yyyy):<input type="text" name="fecha_nacimiento"><br>
		Telefono: <input type="text" name="tlf"><br>
		Correo: <input type="text" name="correo"><br> 
		Usuario: <input type="text" name="usuario"><br> 
		Password:<input type="password" name="pass"><br>
		<input type="button" value="Atras" onclick="window.location = '/inmobiliaria/'" id="atras">
		<input type="submit" value="Añadir" id="ejecute">

	</form>
</body>
</html>