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
		<h1 class="text-center">Fotos</h1><br><br>
		<form action="SubirFotos" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label for="imagenSalon" class="col-sm-offset-3 col-sm-2 form-control-label">ImagenSalon</label>
				<div class="col-sm-3">
					<input type="file" class="form-control" id="imagenSalon" name="imagenSalon">
				</div>
			</div>
			<div class="form-group row">
				<label for="imagenCocina" class="col-sm-offset-3 col-sm-2 form-control-label">ImagenCocina</label>
				<div class="col-sm-3">
					<input type="file" class="form-control" id="imagenCocina" name="imagenCocina">
				</div>
			</div>
			<div class="form-group row">
				<label for="imagenDormitorio" class="col-sm-offset-3 col-sm-2 form-control-label">ImagenDormitorio</label>
				<div class="col-sm-3">
					<input type="file" class="form-control" id="imagenDormitorio" name="imagenDormitorio">
				</div>
			</div>
			<div class="form-group row">
				<label for="imagenBano" class="col-sm-offset-3 col-sm-2 form-control-label">Descripcion</label>
				<div class="col-sm-3">
					<input type="file" class="form-control" id="imagenBano" name="imagenBano">
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