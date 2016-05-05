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
	<link href="<c:url value="/resources/css/Piso.css"/>" rel="stylesheet">
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
							<li><a href="Paypal">Añadir un piso</a></li>
							<li><a href="CerrarSesion">Cerrar Sesion</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<div class="main container">
		<div class="row">
			<h1 class="text-center"><c:out value="${piso.direccion }"/></h1>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
				    <ol class="carousel-indicators">
				    	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
			    	</ol>
				    <div class="carousel-inner" role="listbox">
				    	<div class="item active">
				        	<img src='<c:out value="${piso.imagenSalon}"/>'>
				        	<div class="carousel-caption">
				          		<h3>Salon</h3>
				        	</div>
				      	</div>
				      	<div class="item">
				        	<img src='<c:out value="${piso.imagenCocina }"/>'>
				        	<div class="carousel-caption">
				          		<h3>Cocina</h3>
				        	</div>
				      	</div>
				    
				      	<div class="item">
				        	<img src='<c:out value="${piso.imagenDormitorio}"/>'>
				        	<div class="carousel-caption">
				          		<h3>Dormitorio</h3>
				        	</div>
				      	</div>
						<div class="item">
							<img src='<c:out value="${piso.imagenBano}"/>'>
					        <div class="carousel-caption">
					        	<h3>Baño</h3>
					        </div>
						</div>
			 		</div>
					<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			      		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			      		<span class="sr-only">Previous</span>
			   	 	</a>
			    	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			      		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			      		<span class="sr-only">Next</span>
			    	</a>
			  	</div>
		  	</div>
		  	<div class="col-md-6">
		  		<p><c:out value="${piso.descripcion }"/>
		  	</div>
		  	<div class="col-md-3">
		  		<form action="BajaPiso" method="post">
		  			<input type="hidden" name="cod_piso" value='<c:out value="${piso.cod_piso }"></c:out>'> 
		  			<button type="submit" class="btn btn-danger form-control">Dar de Baja</button>
		  		</form>
		  	</div>
	  	</div>
	  	<br>
	  	<div class="row">
	  		<div class="col-md-12">
	  			<table class="table table-striped table-hover ">
	  				<tr>
	  					<th>Nombre</th>
	  					<th>Apellidos</th>
	  					<th>E-mail</th>
	  					<th>Telefono</th>
	  				</tr>
	  				<c:forEach var="list" items="${lalumnos}" varStatus="estado">
	  				<tr>
	  					<td><c:out value="${list.nombre }"/></td>
	  					<td><c:out value="${list.apellidos }"/></td>
	  					<td><c:out value="${list.correo }"/></td>
	  					<td><c:out value="${list.tlf }"/></td>
	  				</tr>
	  				</c:forEach>
	  			</table>
	  		</div>
	  	</div>
	</div>
	<script src='<c:url value="/resources/bootstrap/js/jquery.min.js"/>'></script>
	<script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
</body>
</html>