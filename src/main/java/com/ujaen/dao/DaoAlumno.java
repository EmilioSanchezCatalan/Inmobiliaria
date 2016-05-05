package com.ujaen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ujaen.dao_interfaces.DaoAlumno_interface;
import com.ujaen.dto.DtoAlumno;
import com.ujaen.dto.DtoAutentifica;
import com.ujaen.dto.DtoPiso;

public class DaoAlumno implements DaoAlumno_interface {

	Dao dao;

	public DaoAlumno() {
		dao = new Dao();
	}

	public void insertar(DtoAlumno alumno) {
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

	public String cogerDNI(DtoAutentifica autentifica) {
		String dni = null;
		String sql = "select dni from alumnos where usuario = ?;";
		ResultSet rs = null;
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, autentifica.getUsuario());
			rs = smt.executeQuery();
			while (rs.next()) {
				dni = rs.getString(1);
			}
			rs.close();
			smt.close();
			dao.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dni;
	}

	public void suscribirsePiso(DtoPiso piso, DtoAlumno alumno) {
		String sql = "update alumnos set cod_piso = ? where dni = ?;";
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, piso.getCod_piso());
			stmt.setString(2, alumno.getDni());
			stmt.execute();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void desSuscribirse(DtoAlumno alumno){
		String sql = "update alumnos set cod_piso = null where dni = ?;";
		dao.getConnection();
		try{
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setString(1, alumno.getDni());
			stmt.execute();
			stmt.close();
			dao.conn.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	public ArrayList<DtoAlumno> inquilinos(DtoAlumno alumno){
		String sql = "select * from alumnos where cod_piso = ?;";
		ArrayList<DtoAlumno> lalumnos = new ArrayList<DtoAlumno>();
		DtoAlumno daoAlumno;
		ResultSet rs = null;
		dao.getConnection();
		try{
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, alumno.getCod_piso());
			rs = stmt.executeQuery();
			while(rs.next()){
				daoAlumno = new DtoAlumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
				lalumnos.add(daoAlumno);
			}
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return lalumnos;
	}
	public DtoAlumno tienePiso(DtoAlumno alumno){
		String sql = "select cod_piso from alumnos where dni = ?;";
		ResultSet rs = null;
		dao.getConnection();
		try{
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setString(1, alumno.getDni());
			rs = stmt.executeQuery();
			while(rs.next()){
				alumno.setCod_piso(rs.getInt(1));
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return alumno;
	}
}
