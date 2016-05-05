<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
	<title>Inuja</title>
</head>
<body>
	<header>
		<div class="container">
			<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a href="/inmobiliaria/" class="navbar-brand">Inuja</a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li><a href="Registrarse">Registrarse</a></li>
							<li><a href="Sesion">Iniciar sesion</a></li>
							<li><a href="">Contacto</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	
	<div class="main">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<h2>
						Crear una cuenta Inuja.<br>
						<small>Hay dos tipos de cuentas.</small>
					</h2>
				
			
					<form action="Registro" method="POST">
						<div class="form-group text-right">
							<input type="radio" name="registrar" checked value="alumno" />Alumno<br />
							<p>Crea una cuenta alumno para encontrar piso de forma rapida y sencilla</p>
							<input type="radio" name="registrar" value="propietario" />Propietario<br />
							<p>Consigue alquilar rapido y de forma eficiente tus pisos.</p>
						</div>
						<div class="form-group text-right">
							<button type="submit" class="btn btn-secondary">Siguiente</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src='<c:url value="/resources/bootstrap/js/jquery.min.js"/>'></script>
	<script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
</body>
</html>