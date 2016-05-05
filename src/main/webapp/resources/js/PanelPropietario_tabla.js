var url = "JPisosPropietario";
xhttp = new XMLHttpRequest();
xhttp.open("GET", url, true);
xhttp.send();

xhttp.onreadystatechange = function() {
	if (xhttp.readyState == 4) {
		if (xhttp.status == 200) {
			var data = JSON.parse(xhttp.responseText);
			if (data != '') {
				var iter;
				var html = '';
				for (iter = 0; iter < data.length; iter++) {
					var cod_piso = data[iter].cod_piso;
					var imagen = data[iter].imagen;
					var direccion = data[iter].direccion;
					var descripcion = data[iter].descripcion;
					var plazas = data[iter].plazas;
					var precio = data[iter].precio;
					var html_user = '<div class="container">'
						+ '<div class="row">'
						+ '<div class="panel panel-default">'
						+ '<div class=panel-header>' + '<h3>' + direccion+ '</h3>' + '</div>'
						+ '<div class="panel-body">'
						+ '<div class="col-md-4">' + '<img src="' + imagen
						+ '" class="img-rounded center-block">'
						+ '</div>'
						+ '<div class="col-md-8">'
						+ '<p class="text-center">' + descripcion +'</p>'
						+ '</div>'
						+ '</div>'
						+ '<div class=panel-footer">'
						+ '<div class="media">'
						+ '<div class="media-body media-middle">'
						+ '<p class="text-right">Plazas '+plazas+', Precio '+precio+'€</p>'
						+ '</div>'
						+ '<div class="media-right">'
						+ '<form action="Piso" method="post">'
						+ '<input type="hidden" name="cod_piso" value="'+ cod_piso +'"> '
						+ '<button type="submit" class="btn btn-primary btn-lg">Ver más +</button> </form>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
						+'</div></div></div>';

					html = html + html_user;
				}


			}
			else{
				var html ='<div class="container">' + '<div class="panel panel-default">'
						+ '<div class="panel-body"><h1 class="text-center">No hay ningun piso</h1></div></div></div>';
			}
		}
	}
	document.getElementById("lista_pisos").innerHTML = html;
}