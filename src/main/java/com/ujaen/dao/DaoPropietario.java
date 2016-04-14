package com.ujaen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ujaen.dto.DtoPropietario;

public class DaoPropietario implements DaoPropietario_interface {
	Dao dao;

	public DaoPropietario() {
		dao = new Dao();
	}

	public void insertar(DtoPropietario propietario) {
		String sql = "INSERT into Propietario (dni,nombre,apellidos,tlf,correo,usuario) VALUES(?,?,?,?,?,?);";
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, propietario.getDni());
			smt.setString(2, propietario.getNombre());
			smt.setString(3, propietario.getApellidos());
			smt.setString(4, propietario.getTlf());
			smt.setString(5, propietario.getCorreo());
			smt.setString(6, propietario.getUsuario());
			smt.execute();
			smt.close();
			dao.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean existeUsuario(DtoPropietario propietario) {
		String sql = "SELECT IF (exists(SELECT * FROM propietario where usuario = ?),true, false);";
		ResultSet rs = null;
		boolean existe = false;
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, propietario.getUsuario());
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