<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ES">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport"
			content="width=device-width, user-scalable=no initial-scale=1.0 maximum-scale=1.0, minimum-scale=1.0">
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
						<div class = "navbar-header">
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
		<section class="main">
			<div class="container">
				<div class="panel panel-warning">
					<div class="panel-body">
						<h1 class="text-center">Error en la autentificacion</h1>
					</div>
				</div>
			</div>
		</section>
		<script src='<c:url value="/resources/bootstrap/js/jquery.min.js"/>'></script>
		<script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
	
	</body>
</html>