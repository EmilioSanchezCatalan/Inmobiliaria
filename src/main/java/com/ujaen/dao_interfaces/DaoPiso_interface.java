package com.ujaen.dao_interfaces;

import java.util.ArrayList;

import com.ujaen.dto.DtoPiso;
import com.ujaen.dto.DtoPropietario;

public interface DaoPiso_interface {

	public ArrayList<DtoPiso> listar();
	public ArrayList<DtoPiso> listarPropietario(DtoPropietario propietario);
	public void insertarPiso(DtoPiso piso);
	public ArrayList<DtoPiso> PisosDisponibles();
	public int totalPisos();
	public void actualizaPlazasMenos(DtoPiso piso);
	public DtoPiso Piso(DtoPiso piso);
	public void BajaPiso(DtoPiso piso);
}
