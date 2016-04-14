<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/estilos/index.css"/>"
	rel="stylesheet">
<title>Inuja</title>
</head>
<body>
	<h1>Inuja</h1>

	<div id="header">
		<ul class="nav">
			<li><a href="Registrarse">Registrarse</a></li>
			<li><a href="Sesion">Iniciar sesion</a></li>
			<!--Sin implementar-->
			<li><a href="">Listar pisos</a> <!--Sin implementar-->
				<ul>
					<li><a href="">Listar pisos por direccion</a></li>
					<!--Sin implementar-->
					<li><a href="">Listar pisos por propietario</a></li>
					<!--Sin implementar-->
				</ul></li>
			<li><a href="">Contacto</a></li>

		</ul>
	</div>

	<div id="lista_pisos"></div>
	<script type="text/javascript">
		var url = "Jpisos";
		xhttp = new XMLHttpRequest();
		xhttp.open("GET", url, true);
		xhttp.send();

		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
				if (xhttp.status == 200) {
					var data = JSON.parse(xhttp.responseText);
					if (data != '') {
						var iter;
						var html = '<table>';
						for (iter = 0; iter < data.length; iter++) {
							var imagen = data[iter].imagen;
							var direccion = data[iter].direccion;
							var descripcion = data[iter].descripcion;
							var plazas = data[iter].plazas;
							var precio = data[iter].precio;
							var html_user = '<tr>'
									+ '<td>'
									+ '<img id = "imagenPrincipal" src="<c:url value="/' + imagen +'"/>">'
									+ '</td>' + '<td>' + direccion + '</td>'
									+ '<td>' + descripcion + '</td>' + '<td>'
									+ plazas + '</td>' + '<td>' + precio
									+ '</td>' + '</tr>';

							html = html + html_user;
						}

						html = html + '</table>';

					}
				}
			}
			document.getElementById("lista_pisos").innerHTML = html;
		}
	</script>

</body>
</html>