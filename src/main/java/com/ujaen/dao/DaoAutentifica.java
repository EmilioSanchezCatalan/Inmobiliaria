package com.ujaen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ujaen.dao.Dao;
import com.ujaen.dao_interfaces.DaoAutentifica_interface;
import com.ujaen.dto.DtoAutentifica;

public class DaoAutentifica implements DaoAutentifica_interface {
	Dao dao;

	public DaoAutentifica() {
		dao = new Dao();
	}

	public void insertar(DtoAutentifica autentifica) {
		String sql = "INSERT into Autentifica (usuario, pass) VALUES(?,?);";
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, autentifica.getUsuario());
			smt.setString(2, autentifica.getPass());
			smt.execute();
			smt.close();
			dao.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean existeUsuario(DtoAutentifica autentifica) {
		String sql = "SELECT IF (exists(SELECT * FROM autentifica where usuario = ?),true, false);";
		ResultSet rs = null;
		boolean existe = false;
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, autentifica.getUsuario());
			rs = smt.executeQuery();
			while (rs.next()) {
				existe = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	public boolean Auntenficado(DtoAutentifica autentifica) {
		String sql = "SELECT IF (exists(SELECT * FROM autentifica where usuario = ? and pass = ?),true, false);";
		ResultSet rs = null;
		boolean existe = false;
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, autentifica.getUsuario());
			smt.setString(2, autentifica.getPass());
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
