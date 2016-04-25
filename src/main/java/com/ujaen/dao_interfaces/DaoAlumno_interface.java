package com.ujaen.dao_interfaces;

import com.ujaen.dto.DtoAlumno;

public interface DaoAlumno_interface {
	public void insertar(DtoAlumno alumno);

	boolean existeUsuario(DtoAlumno alumno);
}
