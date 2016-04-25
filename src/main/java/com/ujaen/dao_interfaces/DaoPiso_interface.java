package com.ujaen.dao_interfaces;

import java.util.ArrayList;

import com.ujaen.dto.DtoPiso;

public interface DaoPiso_interface {

	public ArrayList<DtoPiso> listar();

	public ArrayList<DtoPiso> listarPropietario(String dni);
}
