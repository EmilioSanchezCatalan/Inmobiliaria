package com.ujaen.inmobiliaria;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ujaen.dao.*;
import com.ujaen.dto.*;

@Controller
public class HomeController {
	String usuarioOn;
	
	// Principal
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	// JSON DE LOS PISOS
	@RequestMapping(value = "/Jpisos", method = RequestMethod.GET)
	public String jpisos(Model model) {
		DaoPiso dao = new DaoPiso();
		ArrayList<DtoPiso> lpisos = dao.listar();
		model.addAttribute("lpisos", lpisos);
		return "jpisos";
	}

	@RequestMapping(value = "/Registrarse", method = RequestMethod.GET)
	public String registrar() {
		return "registrar";
	}

	@RequestMapping(value = "/Registro", method = RequestMethod.POST)
	public String elegir(HttpServletRequest req) {

		String registrar = req.getParameter("registrar");

		if (registrar.equals("alumno")) {
			return "CrearAlumno";
		} else
			return "CrearPropietario";
	}

	@RequestMapping(value = "/propietario", method = RequestMethod.POST)
	public String insertadoPropietario(HttpServletRequest req) {

		String dni = req.getParameter("dni");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String telefono = req.getParameter("tlf");
		String correo = req.getParameter("correo");
		String usuario = req.getParameter("usuario");
		String pass = req.getParameter("pass");

		DaoAutentifica daoA = new DaoAutentifica();
		DaoPropietario daoP = new DaoPropietario();
		DtoPropietario propietario = new DtoPropietario();
		DtoAutentifica autentifica = new DtoAutentifica();

		propietario.setDni(dni);
		propietario.setNombre(nombre);
		propietario.setApellidos(apellidos);
		propietario.setTlf(telefono);
		propietario.setCorreo(correo);
		propietario.setUsuario(usuario);
		autentifica.setUsuario(usuario);
		autentifica.setPass(pass);

		if (daoA.existeUsuario(autentifica) == false) {
			daoA.insertar(autentifica);
			daoP.insertar(propietario);
		}

		return "index";
	}

	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	public String insertadoAlumno(HttpServletRequest req) {

		String dni = req.getParameter("dni");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String fecha_nacimiento = req.getParameter("fecha_nacimiento");
		String telefono = req.getParameter("tlf");
		String correo = req.getParameter("correo");
		String usuario = req.getParameter("usuario");
		String pass = req.getParameter("pass");

		DaoAutentifica daoA = new DaoAutentifica();
		DaoAlumno daoAl = new DaoAlumno();
		DtoAlumno alumno = new DtoAlumno();
		DtoAutentifica autentifica = new DtoAutentifica();

		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setFecha_nacimiento(fecha_nacimiento);
		alumno.setTlf(telefono);
		alumno.setCorreo(correo);
		alumno.setUsuario(usuario);
		autentifica.setUsuario(usuario);
		autentifica.setPass(pass);
		if (daoA.existeUsuario(autentifica) == false) {
			daoA.insertar(autentifica);
			daoAl.insertar(alumno);

		}

		return "index";
	}

	@RequestMapping(value = "/Sesion", method = RequestMethod.GET)
	public String inicioSesion() {
		return "iniSesion";
	}

	@RequestMapping(value = "/Autentificacion", method = RequestMethod.POST)
	public String autentificacion(HttpServletRequest req,Model model) {

		String usuario = req.getParameter("usuario");
		String pass = req.getParameter("pass");
		
		DtoAutentifica autentifica = new DtoAutentifica();
		DtoAlumno alumno = new DtoAlumno();
		DtoPropietario propietario = new DtoPropietario();
		
		autentifica.setUsuario(usuario);
		autentifica.setPass(pass);
		alumno.setUsuario(usuario);
		propietario.setUsuario(usuario);
				
		
		DaoAutentifica daoA = new DaoAutentifica();
		DaoAlumno daoAl = new DaoAlumno();
		DaoPropietario daoP = new DaoPropietario();
				
		if (daoA.Auntenficado(autentifica)==true){
			if(daoAl.existeUsuario(alumno)){
				model.addAttribute("usuario", usuario);
				return "PanelAlumno";
			}
			else if(daoP.existeUsuario(propietario)){
				usuarioOn = usuario;
				model.addAttribute("usuario", usuario);
				return "PanelPropietario";
			}
		}
		return "ErrorAuth";
	}
	
	@RequestMapping(value = "/JPisosPropietario", method = RequestMethod.GET)
	public String verPisosP(Model model) {
		
		DaoPiso dao = new DaoPiso();
		DaoPropietario daoP = new DaoPropietario();
		
		String dni = daoP.cogerDNI(usuarioOn);
				
		ArrayList<DtoPiso> lpisos = dao.listarPropietario(dni);
		model.addAttribute("lpisos", lpisos);
		return "jpisos";
	
	}
	
	@RequestMapping(value = "/PisosPropietario", method = RequestMethod.GET)
	public String verpisosP() {
		return "VerPisosPropietario";	
	}
	
	
	
	@RequestMapping(value = "/CerrarSesion", method = RequestMethod.GET)
	public String cerrarSesion(){
		usuarioOn = null;
		
		return "index";
	}
	
	@RequestMapping(value = "/CrearPiso", method = RequestMethod.GET)
	public String insertarPiso(){
		return "insertarPiso";
	}
	
	@RequestMapping(value = "/InsertPiso", method = RequestMethod.POST)
	public String insertPiso(HttpServletRequest req){
		
		String imagen = req.getParameter("imagen");
		String direccion  = req.getParameter("direccion");
		String descripcion  = req.getParameter("descripcion");
		String plazas  = req.getParameter("plazas");
		String precio  = req.getParameter("precio");
				
		DtoPiso piso = new DtoPiso();
		
		piso.setImagen(imagen);
		piso.setDireccion(direccion);
		piso.setDescripcion(descripcion);
		piso.setPlazas(plazas);
		piso.setPrecio(precio);
		
	   
	    DaoPiso daoP = new DaoPiso();
	    DaoPropietario daoPr = new DaoPropietario();
	    String dni = daoPr.cogerDNI(usuarioOn);
	    
	    piso.setDni_p(dni);
	    
	    daoP.insertarPiso(piso);
	   
		
		return "PanelPropietario";
	}

	@RequestMapping(value = "/ListarPlazas", method = RequestMethod.GET)
	public String listarPlazas(HttpServletRequest req,Model model){
		DaoPiso dao = new DaoPiso();
		
		//String plazas = req.getParameter("plazas");
		//System.out.println(plazas);
		String plazas ="4";
		ArrayList<DtoPiso> lpisos = dao.listarPlazas(plazas);
		model.addAttribute("lpisos", lpisos);
		return "jpisos";
		
		
	}
	
	@RequestMapping(value = "/indicarPlazas", method = RequestMethod.GET)
	public String indicarPlazas() {
	
		return "indicarPlazas";
	}
	
	@RequestMapping(value = "/verPisoPl", method = RequestMethod.GET)
	public String verPisoPl() {
	
		return "listarPlazas";
	}
	
}
