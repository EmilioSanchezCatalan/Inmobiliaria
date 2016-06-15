package com.ujaen.inmobiliaria;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ujaen.dao.DaoAlumno;
import com.ujaen.dao.DaoPiso;
import com.ujaen.dto.DtoAlumno;
import com.ujaen.dto.DtoAutentifica;
import com.ujaen.dto.DtoPiso;

@Controller
public class AlumnoConntroller {

	// JSON de los pisos en los que las plazas libres no son 0
	@RequestMapping(value = "/JPisosDisponibles", method = RequestMethod.GET)
	public String verPisosP(Model model, HttpServletRequest req) {

		// declaracion de variables
		DaoPiso daoP = new DaoPiso();
		DaoAlumno daoA = new DaoAlumno();
		ArrayList<DtoPiso> lpisos;
		DtoAlumno alumno = new DtoAlumno();
		DtoAutentifica autentifica = new DtoAutentifica();
		
		// paso de parametros
		autentifica.setUsuario(req.getCookies()[1].getValue());
		alumno.setDni(daoA.cogerDNI(autentifica));
		alumno.setCod_piso(daoA.tienePiso(alumno).getCod_piso());
		
		// funcion
		lpisos = daoP.PisosDisponibles();
		model.addAttribute("lpisos", lpisos);
		model.addAttribute("alumno",alumno);
		
		return "jpisos";
	}

	// Index del panel alumno donde se pueden ver los pisos disponibles.
	@RequestMapping(value = "/listaPisos", method = RequestMethod.GET)
	public String pisosDisponibles() {
		return "PanelAlumno";
	}

	//
	@RequestMapping(value = "/Suscribirse", method = RequestMethod.POST)
	public String Suscribcion(HttpServletRequest req) {
		
		//declaracion de variables
		DaoPiso daoP = new DaoPiso();
		DaoAlumno daoA = new DaoAlumno();
		DtoAutentifica autentifica = new DtoAutentifica();
		DtoAlumno alumno = new DtoAlumno();
		DtoPiso piso = new DtoPiso();

		
		// recepcion de valores
		try{
			autentifica.setUsuario(req.getCookies()[1].getValue());
		}catch(Exception ex){
			return "index";
		}
		
		piso.setCod_piso(Integer.parseInt(req.getParameter("cod_piso")));
		alumno.setDni(daoA.cogerDNI(autentifica));
		
		// funcion
		daoA.suscribirsePiso(piso, alumno);
		daoP.actualizaPlazasMenos(piso);

		return "PanelAlumno";
	}

	//Piso al cual estas suscrito
	@RequestMapping(value = "/MiPiso", method = RequestMethod.GET)
	public String miPiso(HttpServletRequest req, Model model) {
		
		//declaracion de variables
		DaoPiso daoP = new DaoPiso();
		DtoAlumno alumno = new DtoAlumno();
		DtoPiso piso = new DtoPiso();

		//funcion
		try{
			alumno.setUsuario(req.getCookies()[1].getValue());
		}catch(Exception ex){
			return "index";
		}
		piso = daoP.miPiso(alumno);
		model.addAttribute("piso", piso);
		if (piso != null){
			return "MiPiso";
		}else{
			return "NoPiso";
		}
	}
	@RequestMapping(value = "/DesSuscribirse", method = RequestMethod.POST)
	public String DesSuscribirse(HttpServletRequest req){
		
		// declaración de variables
		DaoPiso daoP = new DaoPiso();
		DaoAlumno daoA = new DaoAlumno();
		DtoAlumno alumno = new DtoAlumno();
		DtoPiso piso = new DtoPiso();
		DtoAutentifica autentifica = new DtoAutentifica();
		
		//recepcion de valores
		try{
			autentifica.setUsuario(req.getCookies()[1].getValue());
		}catch(Exception ex){
			return "index";
		}

		alumno.setDni(daoA.cogerDNI(autentifica));
		piso.setCod_piso(Integer.parseInt(req.getParameter("cod_piso")));
		
		//funcion
		daoA.desSuscribirse(alumno);
		daoP.actualizaPlazasMas(piso);
		
		return "PanelAlumno";
	}
}
