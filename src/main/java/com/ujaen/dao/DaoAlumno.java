package com.ujaen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ujaen.dto.DtoAlumno;
import com.ujaen.dto.DtoPropietario;

public class DaoAlumno implements DaoAlumno_interface {

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/inmobiliaria";
	Connection conn;

	public DaoAlumno() {
		cargarDriver();
	}

	private void cargarDriver() {
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void getConnection() {
		try {
			conn = DriverManager.getConnection(url, "ClientePisos", "pass");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertar(DtoAlumno alumno){
		String sql = "INSERT into Alumnos (dni,nombre,apellidos,fecha_nacimiento,tlf,correo,usuario) VALUES(?,?,?,?,?,?,?);";
		getConnection();
		try {
			PreparedStatement smt = conn.prepareStatement(sql);
			smt.setString(1, alumno.getDni());
			smt.setString(2, alumno.getNombre());
			smt.setString(3, alumno.getApellidos());
			smt.setString(4, alumno.getFecha_nacimiento());
			smt.setString(5, alumno.getTlf());
			smt.setString(6, alumno.getCorreo());
			smt.setString(7, alumno.getUsuario());
			smt.execute();
			smt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
