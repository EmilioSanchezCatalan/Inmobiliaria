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
	<section class="main container">
		<div class="panel panel-default">
			<div class="panel-header">
				<h1 class="text-center">Pago del piso<br><small>en caso contrario el piso sera elimnado</small></h1>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3 col-md-offset-5">
						<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" target="_top">
							<input type="hidden" name="cmd" value="_s-xclick">
							<input type="hidden" name="hosted_button_id" value="6JSVQD5L5BHAW">
							<input type="image" src="https://www.sandbox.paypal.com/es_ES/ES/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal. La forma rápida y segura de pagar en Internet.">
							<img alt="" border="0" src="https://www.sandbox.paypal.com/es_ES/i/scr/pixel.gif" width="1" height="1">
							<input type="hidden" name="return" value="http://127.0.0.1:8080/inmobiliaria/Paypal"/>
							<input type='hidden' name='cancel_return' value='http://127.0.0.1:8080/inmobiliaria/Paypal"'>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>	
	<script src='<c:url value="/resources/bootstrap/js/jquery.min.js"/>'></script>
	<script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
</body>
</html>