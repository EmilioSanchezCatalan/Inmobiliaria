<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar piso</title>
</head>
<body>
	Rellene los siguientes datos:
	<form action="InsertPiso" method="post">

		Imagen: <input type="text" name="imagen"><br> 
		Direccion:<input type = "text" name="direccion"><br>
		Plazas: <input type="text" name="plazas"><br>
		Precio: <input type="text" name="precio"><br>
		Descripcion: <br>
		<textarea name="msg" rows="15" cols="50"></textarea>
				
						
		<input type="submit" value="Enviar" />
		

	</form>
</body>
</html>