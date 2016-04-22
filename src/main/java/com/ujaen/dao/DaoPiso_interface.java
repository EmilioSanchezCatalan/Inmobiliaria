package com.ujaen.dao;

import java.util.ArrayList;

import com.ujaen.dto.DtoAutentifica;
import com.ujaen.dto.DtoPiso;

public interface DaoPiso_interface {

	public ArrayList<DtoPiso> listar();
	public ArrayList<DtoPiso> listarPropietario(String dni);
	public ArrayList<DtoPiso> listarPlazas(String plazas);

}
