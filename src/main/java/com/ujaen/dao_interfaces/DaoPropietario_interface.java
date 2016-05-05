package com.ujaen.dao_interfaces;

import com.ujaen.dto.DtoAutentifica;
import com.ujaen.dto.DtoPropietario;

public interface DaoPropietario_interface {
	public void insertar(DtoPropietario propietario);

	public boolean existeUsuario(DtoPropietario propietario);

	public String cogerDNI(DtoAutentifica autentifica);
}
