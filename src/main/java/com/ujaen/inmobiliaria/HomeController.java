package com.ujaen.inmobiliaria;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ujaen.dao.*;
import com.ujaen.dto.*;

@Controller
public class HomeController {
	// Principal
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	// JSON de todos los pisos
	@RequestMapping(value = "/Jpisos", method = RequestMethod.GET)
	public String jpisos(Model model) {

		// declaracion de variables
		DaoPiso dao = new DaoPiso();
		ArrayList<DtoPiso> lpisos;

		// funcion
		lpisos = dao.listar();
		model.addAttribute("lpisos", lpisos);
		return "jpisos";
	}

	// Formulario de eleccion de tipo de cuenta
	@RequestMapping(value = "/Registrarse", method = RequestMethod.GET)
	public String registrar() {
		return "registrar";
	}

	// Recepcion del tipo de cuenta a registrar
	@RequestMapping(value = "/Registro", method = RequestMethod.POST)
	public String elegir(HttpServletRequest req) {

		// declaracion de variables
		String registrar;

		// recepcion
		registrar = req.getParameter("registrar");

		// eleccion del tipo de registro
		if (registrar.equals("alumno")) {
			return "CrearAlumno";
		} else
			return "CrearPropietario";
	}

	// Registrarse como propietario, recepcion de todos los datos y se da del
	// alta en la BBDD
	@RequestMapping(value = "/propietario", method = RequestMethod.POST)
	public String insertadoPropietario(HttpServletRequest req) {

		// declaracion de variables
		DaoAutentifica daoA = new DaoAutentifica();
		DaoPropietario daoP = new DaoPropietario();
		DtoPropietario propietario = new DtoPropietario();
		DtoAutentifica autentifica = new DtoAutentifica();
		String dni, nombre, apellidos, telefono, correo, usuario, pass;

		// recepción de valores
		dni = req.getParameter("dni");
		nombre = req.getParameter("nombre");
		apellidos = req.getParameter("apellidos");
		telefono = req.getParameter("tlf");
		correo = req.getParameter("correo");
		usuario = req.getParameter("usuario");
		pass = req.getParameter("pass");

		// inserción de valores
		propietario.setDni(dni);
		propietario.setNombre(nombre);
		propietario.setApellidos(apellidos);
		propietario.setTlf(telefono);
		propietario.setCorreo(correo);
		propietario.setUsuario(usuario);
		autentifica.setUsuario(usuario);
		autentifica.setPass(pass);

		// funcion
		if (daoA.existeUsuario(autentifica) == false) {
			daoA.insertar(autentifica);
			daoP.insertar(propietario);
		}

		return "index";
	}

	// Registrarse como usuario, recepción de datos y se da de alta en la BBDD
	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	public String insertadoAlumno(HttpServletRequest req) {

		// declaracion de variables
		DaoAutentifica daoA = new DaoAutentifica();
		DaoAlumno daoAl = new DaoAlumno();
		DtoAlumno alumno = new DtoAlumno();
		DtoAutentifica autentifica = new DtoAutentifica();
		String dni, nombre, apellidos, fecha_nacimiento, telefono, correo, usuario, pass;

		// recepción de valores
		dni = req.getParameter("dni");
		nombre = req.getParameter("nombre");
		apellidos = req.getParameter("apellidos");
		fecha_nacimiento = req.getParameter("fecha_nacimiento");
		telefono = req.getParameter("tlf");
		correo = req.getParameter("correo");
		usuario = req.getParameter("usuario");
		pass = req.getParameter("pass");

		// inserción de valores
		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setFecha_nacimiento(fecha_nacimiento);
		alumno.setTlf(telefono);
		alumno.setCorreo(correo);
		alumno.setUsuario(usuario);
		autentifica.setUsuario(usuario);
		autentifica.setPass(pass);

		// funcion
		if (daoA.existeUsuario(autentifica) == false) {
			daoA.insertar(autentifica);
			daoAl.insertar(alumno);

		}

		return "index";
	}

	// Vista con el formulario de iniciar sesion
	@RequestMapping(value = "/Sesion", method = RequestMethod.GET)
	public String inicioSesion() {
		return "iniSesion";
	}

	// Recepcion del formulario de Sesion y comprobación de una autentificacion
	// correcta
	@RequestMapping(value = "/Autentificacion", method = RequestMethod.POST)
	public String autentificacion(HttpServletRequest req, Model model, HttpServletResponse resp) {

		// declaracion de variables
		DaoAutentifica daoA = new DaoAutentifica();
		DaoAlumno daoAl = new DaoAlumno();
		DaoPropietario daoP = new DaoPropietario();
		DtoAutentifica autentifica = new DtoAutentifica();
		DtoAlumno alumno = new DtoAlumno();
		DtoPropietario propietario = new DtoPropietario();
		String usuario, pass;

		// recepción de valores
		usuario = req.getParameter("usuario");
		pass = req.getParameter("pass");

		// inserció de valores
		autentifica.setUsuario(usuario);
		autentifica.setPass(pass);
		alumno.setUsuario(usuario);
		propietario.setUsuario(usuario);

		// funcion
		if (daoA.Auntenficado(autentifica) == true) {
			Cookie sesionCookie = new Cookie("username", usuario);
			resp.addCookie(sesionCookie);
			if (daoAl.existeUsuario(alumno)) {
				model.addAttribute("usuario", usuario);
				return "PanelAlumno";
			} else if (daoP.existeUsuario(propietario)) {
				model.addAttribute("usuario", usuario);
				return "PanelPropietario";
			}
		}
		return "ErrorAuth";
	}

	// Pone a 0 el valor de la Cookie_nombre_de_usuario, con lo que esta expira.
	@RequestMapping(value = "/CerrarSesion", method = RequestMethod.GET)
	public String cerrarSesion(HttpServletRequest req, HttpServletResponse resp) {
		
		// funcion
		try{
			Cookie finSesion = req.getCookies()[1];
		finSesion.setMaxAge(0);
		resp.addCookie(finSesion);
		}catch(Exception ex){
			return "index";
		}
		return "index";
	}
}
