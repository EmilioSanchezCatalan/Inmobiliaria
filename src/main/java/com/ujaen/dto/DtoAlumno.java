package com.ujaen.dto;

public class DtoAlumno {
	private String dni;
	private String nombre;
	private String apellidos;
	private String fecha_nacimiento;
	private String tlf;
	private String correo;
	private int cod_piso;
	private String usuario;

	public DtoAlumno() {

	}

	public DtoAlumno(String dni, String nombre, String apellidos, String fecha_nacimiento, String tlf, String correo,
			int cod_piso, String usuario) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.tlf = tlf;
		this.correo = correo;
		this.cod_piso = cod_piso;
		this.usuario = usuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getCod_piso() {
		return cod_piso;
	}

	public void setCod_piso(int cod_piso) {
		this.cod_piso = cod_piso;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
