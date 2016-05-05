package com.ujaen.inmobiliaria;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ujaen.dao.DaoAlumno;
import com.ujaen.dao.DaoPiso;
import com.ujaen.dao.DaoPropietario;
import com.ujaen.dto.DtoAlumno;
import com.ujaen.dto.DtoAutentifica;
import com.ujaen.dto.DtoPiso;
import com.ujaen.dto.DtoPropietario;

@Controller
public class PropietarioController {

	// JSON de todos los pisos de un propietario
	@RequestMapping(value = "/JPisosPropietario", method = RequestMethod.GET)
	public String verPisosP(Model model, HttpServletRequest req) {

		// declaracion de variables
		DaoPiso daoPi = new DaoPiso();
		DaoPropietario daoPr = new DaoPropietario();
		DtoAutentifica autentifica = new DtoAutentifica();
		DtoPropietario propietario = new DtoPropietario();
		ArrayList<DtoPiso> lpisos;

		// recepion de valores
		try {
			autentifica.setUsuario(req.getCookies()[1].getValue());
		} catch (Exception ex) {
			return "index";
		}
		propietario.setDni(daoPr.cogerDNI(autentifica));
		lpisos = daoPi.listarPropietario(propietario);

		// funcion
		model.addAttribute("lpisos", lpisos);
		return "jpisos";

	}

	// Index del panel propietario, en el se muestran los pisos del propietario.
	@RequestMapping(value = "/PisosPropietario", method = RequestMethod.GET)
	public String listPisosPropietario() {
		return "PanelPropietario";
	}
	// Vista de pago no realizado
	@RequestMapping(value = "/noPaypal", method = RequestMethod.GET)
	public String noPaypal(){
		DaoPiso daoP = new DaoPiso();
		daoP.noPagado();
		return "PagoIncorrecto";
	}
	// Vista de pago realizado
	@RequestMapping(value = "/Paypal", method = RequestMethod.GET)
	public String Paypal(HttpServletRequest req) {
		
		// decalaracion de variables
		DaoPiso daoP = new DaoPiso();
		
		// funcion
		daoP.pagado();
		
		return "PagoCorrecto";
	}

	// Vista para crear un piso, con el formulario de los datos del mismo.
	@RequestMapping(value = "/CrearPiso", method = RequestMethod.GET)
	public String insertarPiso() {
		return "insertarPiso";
	}

	// Recoge los datos del formulario anterior y los da de alta en la base de
	// datos.
	@RequestMapping(value = "/InsertPiso", method = RequestMethod.POST)
	public String insertPiso(HttpServletRequest req) {

		// declaracion de variables
		DtoPiso piso = new DtoPiso();
		DtoPropietario propietario = new DtoPropietario();
		DtoAutentifica autentifica = new DtoAutentifica();
		DaoPiso daoP = new DaoPiso();
		DaoPropietario daoPr = new DaoPropietario();
		int plazas, numPiso;
		float precio;
		String direccion, descripcion;

		// recepcion de valores
		numPiso = daoP.totalPisos() + 1;
		direccion = req.getParameter("direccion");
		try {
			plazas = Integer.parseInt(req.getParameter("plazas"));
		} catch (Exception ex) {
			plazas = 0;
		}
		try {
			precio = Float.parseFloat(req.getParameter("precio"));
		} catch (Exception ex) {
			precio = 0;
		}
		descripcion = req.getParameter("msg");

		// insercion de valores
		try {
			autentifica.setUsuario(req.getCookies()[1].getValue());
		} catch (Exception ex) {
			return "index";
		}
		propietario.setDni(daoPr.cogerDNI(autentifica));
		piso.setImagenSalon("resources/imagenes/pisos/" + numPiso + "/1.jpg");
		piso.setImagenCocina("resources/imagenes/pisos/" + numPiso + "/2.jpg");
		piso.setImagenDormitorio("resources/imagenes/pisos/" + numPiso + "/3.jpg");
		piso.setImagenBano("resources/imagenes/pisos/" + numPiso + "/4.jpg");
		piso.setDireccion(direccion);
		piso.setPlazas(plazas);
		piso.setPlazas_libres(plazas);
		piso.setPrecio(precio);
		piso.setDescripcion(descripcion);
		piso.setPagado(false);
		piso.setDni_p(propietario.getDni());

		// funcion
		daoP.insertarPiso(piso);

		return "SubirFotos";
	}

	// Procesamiento de las imagenes, y almacenamiento en el servidor
	@RequestMapping(value = "/SubirFotos", method = RequestMethod.POST)
	public String subirFotos(HttpServletRequest req) {

		// declaracion de variables
		DaoPiso daoP = new DaoPiso();
		int nfotos = 1;
		int numPiso = daoP.totalPisos();
		String srcEstandar = "C:/Users/windic/Documents/GitHub/Inmobiliaria/src/main/webapp/resources/imagenes/pisos/"
				+ numPiso;
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		// funcion
		try {
			if (ServletFileUpload.isMultipartContent(req)) {
				File Carpeta = new File(srcEstandar);
				if (!Carpeta.exists()) {
					Carpeta.mkdir();
				}
				List<FileItem> fileitemsList = upload.parseRequest(req);
				Iterator<FileItem> it = fileitemsList.iterator();
				while (it.hasNext()) {
					FileItem archivoActual = it.next();
					String nombre = nfotos + ".jpg";
					File archivoADisco = new File(nombre);
					archivoADisco = new File(srcEstandar + "/" + archivoADisco.getName());
					archivoActual.write(archivoADisco);
					nfotos++;
				}
			}
		} catch (FileUploadException ex) {
			ex.getMessage();
		} catch (Exception ex) {
			ex.getMessage();
		}

		return "paypal";
	}

	// Vista de un piso en concreto
	@RequestMapping(value = "/Piso", method = RequestMethod.POST)
	public String Piso(HttpServletRequest req, Model model) {

		// declaracion de variables
		ArrayList<DtoAlumno> lalumnos;
		DtoPiso piso = new DtoPiso();
		DtoAlumno alumno = new DtoAlumno();
		DaoPiso daoP = new DaoPiso();
		DaoAlumno daoA = new DaoAlumno();
		int cod_piso;

		// recepcion de valores
		cod_piso = Integer.parseInt(req.getParameter("cod_piso"));
		piso.setCod_piso(cod_piso);
		piso = daoP.Piso(piso);
		alumno.setCod_piso(cod_piso);
		lalumnos = daoA.inquilinos(alumno);
	
		// funcion
		model.addAttribute("piso", piso);
		model.addAttribute("lalumnos", lalumnos);
		return "Piso";
	}

	// Borrar un piso
	@RequestMapping(value = "/BajaPiso", method = RequestMethod.POST)
	public String bajaPiso(HttpServletRequest req) {

		// declaracion de variables
		DaoPiso daoP = new DaoPiso();
		DtoPiso piso = new DtoPiso();

		// recepcion de valores
		piso.setCod_piso(Integer.parseInt(req.getParameter("cod_piso")));

		// funcion
		daoP.BajaPiso(piso);

		return "PanelPropietario";
	}
}
