package com.ujaen.dto;


public class DtoPiso {
	private int cod_piso;
	private String imagen;
	private String direccion;
	private String descripcion;
	private int plazas;
	private float precio;
	private String dni_p;

	public DtoPiso() {

	}

	public DtoPiso(int cod_piso, String imagen, String direccion, String descripcion, int plazas, float precio,
			String dni_p) {
		this.cod_piso = cod_piso;
		this.imagen = imagen;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.plazas = plazas;
		this.precio = precio;
		this.dni_p = dni_p;
	}

	public int getCod_piso() {
		return cod_piso;
	}

	public void setCod_piso(int cod_piso) {
		this.cod_piso = cod_piso;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDni_p() {
		return dni_p;
	}

	public void setDni_p(String dni_p) {
		this.dni_p = dni_p;
	}

}
