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
				var html = '';
				for (iter = 0; iter < data.length; iter++) {
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
							+'</div>'
							+ '<div class=panel-footer">'
							+ '<p class="text-right">Plazas '+plazas+', Precio '+precio+'€</p>'
							+ '</div>'
							+'</div></div></div>';

					html = html + html_user;
				}

			}
		}
	}
	document.getElementById("lista_pisos").innerHTML = html;
}