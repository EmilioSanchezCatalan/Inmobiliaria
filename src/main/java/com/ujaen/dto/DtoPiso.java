package com.ujaen.dto;

public class DtoPiso {
	private int cod_piso;
	private String imagenSalon;
	private String imagenCocina;
	private String imagenDormitorio;
	private String imagenBano;
	private String direccion;
	private String descripcion;
	private int plazas;
	private int plazas_libres;
	private float precio;
	private boolean pagado;
	private String dni_p;

	public DtoPiso() {

	}

	public DtoPiso(int cod_piso, String imagenSalon, String imagenCocina, String imagenDormitorio, String imagenBano,
			String direccion, String descripcion, int plazas, int plazas_libres, float precio, boolean pagado, String dni_p) {
		super();
		this.cod_piso = cod_piso;
		this.imagenSalon = imagenSalon;
		this.imagenCocina = imagenCocina;
		this.imagenDormitorio = imagenDormitorio;
		this.imagenBano = imagenBano;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.plazas = plazas;
		this.plazas_libres = plazas_libres;
		this.precio = precio;
		this.pagado = pagado;
		this.dni_p = dni_p;
	}

	public int getCod_piso() {
		return cod_piso;
	}

	public void setCod_piso(int cod_piso) {
		this.cod_piso = cod_piso;
	}

	public String getImagenSalon() {
		return imagenSalon;
	}

	public void setImagenSalon(String imagenSalon) {
		this.imagenSalon = imagenSalon;
	}

	public String getImagenCocina() {
		return imagenCocina;
	}

	public void setImagenCocina(String imagenCocina) {
		this.imagenCocina = imagenCocina;
	}

	public String getImagenDormitorio() {
		return imagenDormitorio;
	}

	public void setImagenDormitorio(String imagenDormitorio) {
		this.imagenDormitorio = imagenDormitorio;
	}

	public String getImagenBano() {
		return imagenBano;
	}

	public void setImagenBano(String imagenBano) {
		this.imagenBano = imagenBano;
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

	public int getPlazas_libres() {
		return plazas_libres;
	}

	public void setPlazas_libres(int plaza_libres) {
		this.plazas_libres = plaza_libres;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public String getDni_p() {
		return dni_p;
	}

	public void setDni_p(String dni_p) {
		this.dni_p = dni_p;
	}

}
