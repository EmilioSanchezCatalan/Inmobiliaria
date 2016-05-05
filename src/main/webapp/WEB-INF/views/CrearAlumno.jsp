<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/css/CrearAlumno.css"/>" rel="stylesheet">
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
	<div class="main container">
		<h1 class="text-center">Rellene los siguientes datos</h1><br><br>
		<form action="alumno" method="post">
			<div class="form-group row">
				<label for="dni" class="col-sm-offset-3 col-sm-2 form-control-label">Dni</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="dni" placeholder="0000000A" name="dni">
				</div>
			</div>
			<div class="form-group row">
				<label for="nombre" class="col-sm-offset-3 col-sm-2 form-control-label">Nombre</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
				</div>
			</div>
			<div class="form-group row">
				<label for="apellidos" class="col-sm-offset-3 col-sm-2 form-control-label">Apellidos</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="apellidos" placeholder="Apellidos" name="apellidos">
				</div>
			</div>
			<div class="form-group row">
				<label for="fecha" class="col-sm-offset-3 col-sm-2 form-control-label">Fecha de nacimiento</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="fecha" placeholder="dd/mm/yyyy" name="fecha_nacimiento">
				</div>
			</div>
			<div class="form-group row">
				<label for="tlf" class="col-sm-offset-3 col-sm-2 form-control-label">Telefono</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="tlf" placeholder="000000000" name="tlf">
				</div>
			</div>
			<div class="form-group row">
				<label for="email" class="col-sm-offset-3 col-sm-2 form-control-label">Email</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="email" placeholder="username@example.com" name="correo">
				</div>
			</div>
			<div class="form-group row">
				<label for="username" class="col-sm-offset-3 col-sm-2 form-control-label">Usuario</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="username" placeholder="nombre de usuario" name="usuario">
				</div>
			</div>
			<div class="form-group row">
				<label for="pass" class="col-sm-offset-3 col-sm-2 form-control-label">Password</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" id="pass" placeholder="contraseña" name="pass">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-5 col-sm-3">
		      		<button type="submit" class="btn btn-secondary">Registrarse</button>
		    	</div>
		    </div>
		
		</form>
	</div>
	<script src='<c:url value="/resources/bootstrap/js/jquery.min.js"/>'></script>
	<script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
</body>
</html>