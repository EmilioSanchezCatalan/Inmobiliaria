<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/css/iniSesion.css"/>" rel="stylesheet">
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
							<li><a href="Sesion">Iniciar sesión</a></li>
							<li><a href="Contacto">Contacto</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<div class="main container">
		<h1 class = "text-center">Inicio de Sesion</h1>
		<form action="Autentificacion" method="post">
			<div class="form-group row">
				<div class="col-sm-offset-4 col-sm-4">
				<input type="text" class="form-control" placeholder="Nombre de usuario" name="usuario">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-4 col-sm-4">
					<input type="password" class="form-control" placeholder="Contraseña" name="pass">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-4 col-sm-4">
		      		<button type="submit" class="form-control btn btn-primary">Inicio</button>
		    	</div>
		    </div>
		</form>
	</div>
</body>
</html>