package com.ujaen.dao_interfaces;

import com.ujaen.dto.DtoAutentifica;

public interface DaoAutentifica_interface {
	public void insertar(DtoAutentifica autentifica);
	public boolean existeUsuario(DtoAutentifica autentifica);
	public boolean Auntenficado(DtoAutentifica autentifica);
}
