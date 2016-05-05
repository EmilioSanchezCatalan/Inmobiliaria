package com.ujaen.dao_interfaces;

import com.ujaen.dto.DtoAlumno;
import com.ujaen.dto.DtoAutentifica;
import com.ujaen.dto.DtoPiso;

public interface DaoAlumno_interface {
	public void insertar(DtoAlumno alumno);
	public boolean existeUsuario(DtoAlumno alumno);
	public String cogerDNI(DtoAutentifica autentifica);
	public void suscribirsePiso(DtoPiso piso, DtoAlumno alumno);
	public void desSuscribirse(DtoAlumno alumno);
}
