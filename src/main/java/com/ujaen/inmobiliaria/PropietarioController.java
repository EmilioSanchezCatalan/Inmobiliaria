package com.ujaen.inmobiliaria;



import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ujaen.dao.DaoPiso;
import com.ujaen.dao.DaoPropietario;
import com.ujaen.dto.DtoPiso;

@Controller
public class PropietarioController {
	
	// JSON de todos los pisos de un propietario
	@RequestMapping(value = "/JPisosPropietario", method = RequestMethod.GET)
	public String verPisosP(Model model, HttpServletRequest req) {

		DaoPiso dao = new DaoPiso();
		DaoPropietario daoP = new DaoPropietario();

		String dni = daoP.cogerDNI(req.getCookies()[1].getValue());

		ArrayList<DtoPiso> lpisos = dao.listarPropietario(dni);
		model.addAttribute("lpisos", lpisos);
		return "jpisos";

	}
	@RequestMapping(value = "/PisosPropietario", method = RequestMethod.GET)
	public String listPisosPropietario() {
		return "PanelPropietario";
	}
	@RequestMapping(value = "/CrearPiso", method = RequestMethod.GET)
	public String insertarPiso() {
		return "insertarPiso";
	}

	@RequestMapping(value = "/InsertPiso", method = RequestMethod.POST)
	public String insertPiso(HttpServletRequest req) {
		
		DtoPiso piso = new DtoPiso();
		DaoPiso daoP = new DaoPiso();
		DaoPropietario daoPr = new DaoPropietario();
		
		int plazas;
		float precio;
		String direccion, descripcion;
		
		int numPiso = daoP.totalPisos() + 1;
		
		direccion = req.getParameter("direccion");
		try{
			plazas = Integer.parseInt(req.getParameter("plazas"));
		}catch(Exception ex){
			plazas = 0;
		}
		try{
			precio = Float.parseFloat(req.getParameter("precio"));
		}catch(Exception ex){
			precio = 0;
		}
		descripcion = req.getParameter("msg");
		
		piso.setImagenSalon("resources/imagenes/pisos/"+numPiso+"/1.jpg");
		piso.setImagenCocina("resources/imagenes/pisos/"+numPiso+"/2.jpg");
		piso.setImagenDormitorio("resources/imagenes/pisos/"+numPiso+"/3.jpg");
		piso.setImagenBano("resources/imagenes/pisos/"+numPiso+"/4.jpg");
		piso.setDireccion(direccion);
		piso.setPlazas(plazas);
		piso.setPrecio(precio);
		piso.setDescripcion(descripcion);
		piso.setDni_p(daoPr.cogerDNI(req.getCookies()[1].getValue()));
		
		daoP.insertarPiso(piso);
		return "SubirFotos";
	}
	@RequestMapping(value = "/SubirFotos", method = RequestMethod.POST)
	public String subirFotos(HttpServletRequest req){
		
		DaoPiso daoP = new DaoPiso();

		int nfotos = 1;
		int numPiso = daoP.totalPisos();
		String srcEstandar ="C:/Users/windic/Documents/GitHub/Inmobiliaria/src/main/webapp/resources/imagenes/pisos/"+numPiso;
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		try{
			if (ServletFileUpload.isMultipartContent(req)){
				File Carpeta = new File(srcEstandar);
				if (!Carpeta.exists()){
					Carpeta.mkdir();
				}
				List<FileItem> fileitemsList = upload.parseRequest(req);
				Iterator<FileItem> it = fileitemsList.iterator();
				while(it.hasNext()){
					FileItem archivoActual =  it.next();
					String nombre = nfotos+".jpg";
					File archivoADisco = new File(nombre);
					archivoADisco = new File(srcEstandar+"/"+archivoADisco.getName());
					archivoActual.write(archivoADisco);
					nfotos++;
				}
			}
		}catch(FileUploadException ex){
			ex.getMessage();
		}catch (Exception ex) {
			ex.getMessage();
		}
		return "PanelPropietario";
	}
	@RequestMapping(value = "/CerrarSesion", method = RequestMethod.GET)
	public String cerrarSesion(HttpServletRequest req, HttpServletResponse resp) {
		Cookie finSesion = req.getCookies()[1];
		finSesion.setMaxAge(0);
		resp.addCookie(finSesion);
		return "index";
	}

}
