<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inuja</title>
</head>
<body>
	<form action="SubirFotos" method="post" enctype="multipart/form-data">

		ImagenSalon: <input type="file" name="imagenSalon"><br>
		ImagenCocina: <input type="file" name="imagenCocina"><br>
		ImagenDormitorio: <input type="file" name="imagenDormitorio"><br>
		ImagenBaño: <input type="file" name="imagenBano"><br>
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>