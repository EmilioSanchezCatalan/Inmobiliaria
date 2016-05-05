<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no initial-scale=1.0 
			maximum-scale=1.0, minimum-scale=1.0">
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"
			rel="stylesheet">
	<link href="<c:url value="/resources/css/insertarPiso.css"/>" rel="stylesheet">
	<title>Inuja</title>
</head>
<body>
	<header>
		<div class="container">
			<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
				<div class="container-fluid">
					<div class = "navbar-header">
						<a href="PisosPropietario" class="navbar-brand">Inuja <small>panel propietario</small></a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li><a href="PisosPropietario">Mis pisos</a></li>
							<li><a href="CrearPiso">Añadir un piso</a></li>
							<li><a href="CerrarSesion">Cerrar Sesion</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<div class="main container">
		<h1 class="text-center">Añadir Piso</h1><br><br>
		<form action="InsertPiso" method="post">
			<div class="form-group row">
				<label for="direccion" class="col-sm-offset-3 col-sm-2 form-control-label">Direccion</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="direccion" placeholder="Dirección" name="direccion">
				</div>
			</div>
			<div class="form-group row">
				<label for="plazas" class="col-sm-offset-3 col-sm-2 form-control-label">Plazas</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="plazas" placeholder=" nº Plazas" name="plazas">
				</div>
			</div>
			<div class="form-group row">
				<label for="precio" class="col-sm-offset-3 col-sm-2 form-control-label">Precio</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="precio" placeholder="Precio" name="precio">
				</div>
			</div>
			<div class="form-group row">
				<label for="descripcion" class="col-sm-offset-3 col-sm-2 form-control-label">Descripcion</label>
				<div class="col-sm-3">
					<textarea class="form-control" id="descripcion" placeholder="Descripcion" name="msg" rows="10" cols="50"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-5 col-sm-3">
		      		<button type="submit" class="btn btn-secondary">Añadir</button>
		    	</div>
		    </div>
		</form>
	</div>	
	<script src='<c:url value="/resources/bootstrap/js/jquery.min.js"/>'></script>
	<script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
</body>
</html>