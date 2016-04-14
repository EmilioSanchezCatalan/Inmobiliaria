package com.ujaen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ujaen.dto.DtoAlumno;


public class DaoAlumno implements DaoAlumno_interface {

	Dao dao;

	public DaoAlumno() {
		dao = new Dao();
	}
	
	public void insertar(DtoAlumno alumno){
		String sql = "INSERT into Alumnos (dni,nombre,apellidos,fecha_nacimiento,tlf,correo,usuario) VALUES(?,?,?,?,?,?,?);";
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, alumno.getDni());
			smt.setString(2, alumno.getNombre());
			smt.setString(3, alumno.getApellidos());
			smt.setString(4, alumno.getFecha_nacimiento());
			smt.setString(5, alumno.getTlf());
			smt.setString(6, alumno.getCorreo());
			smt.setString(7, alumno.getUsuario());
			smt.execute();
			smt.close();
			dao.conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean existeUsuario(DtoAlumno alumno) {
		String sql = "SELECT IF (exists(SELECT * FROM alumnos where usuario = ?),true, false);";
		ResultSet rs = null;
		boolean existe = false;
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, alumno.getUsuario());
			rs = smt.executeQuery();
			while (rs.next()) {
				existe = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

}
