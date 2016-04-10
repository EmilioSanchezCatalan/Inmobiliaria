package com.ujaen.inmobiliaria;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import org.junit.internal.matchers.SubstringMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ujaen.dao.DaoAlumno;
import com.ujaen.dao.DaoPiso;
import com.ujaen.dao.DaoPropietario;
import com.ujaen.dto.DtoAlumno;
import com.ujaen.dto.DtoPiso;
import com.ujaen.dto.DtoPropietario;


@Controller
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/Jpisos", method = RequestMethod.GET)
	public String jpisos(Model model){
		DaoPiso dao = new DaoPiso();
		ArrayList<DtoPiso> lpisos = dao.listar();
		model.addAttribute("lpisos", lpisos);
		return "jpisos";
	}
	@RequestMapping(value = "/Registrarse", method = RequestMethod.POST)
	public String registrar(){
		return "registrar";
	}
	@RequestMapping(value = "/Elegir", method = RequestMethod.POST)
	public String elegir(HttpServletRequest req){
		
		String registrar = req.getParameter("registrar");
			
		if (registrar.equals("alumno")){
			return "CrearAlumno";
		}
		else return "CrearPropietario";
	}
	
	@RequestMapping(value = "/propietario", method = RequestMethod.POST)
	public String insertadoPropietario(HttpServletRequest req){
		
		String	dni = req.getParameter("dni");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String telefono = req.getParameter("tlf");
		String correo = req.getParameter("correo");
		
		
		DaoPropietario dao = new DaoPropietario();
		DtoPropietario propietario = new DtoPropietario();
		
		
		propietario.setDni(dni);
		propietario.setNombre(nombre);
		propietario.setApellidos(apellidos);
		propietario.setTlf(telefono);
		propietario.setCorreo(correo);
		
		dao.insertar(propietario);
		
		return "index";
	}
	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	public String insertadoAlumno(HttpServletRequest req){
		
		String	dni = req.getParameter("dni");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String fecha_nacimiento = req.getParameter("fecha_nacimiento");
		String telefono = req.getParameter("tlf");
		String correo = req.getParameter("correo");
		String usuario = req.getParameter("usuario");
		
		
		DaoAlumno dao = new DaoAlumno();
		DtoAlumno alumno = new DtoAlumno();
		
		
		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setFecha_nacimiento(fecha_nacimiento);
		alumno.setTlf(telefono);
		alumno.setCorreo(correo);
		alumno.setUsuario(usuario);
		
		dao.insertar(alumno);
		
		return "index";
	}
			
	
	
}
