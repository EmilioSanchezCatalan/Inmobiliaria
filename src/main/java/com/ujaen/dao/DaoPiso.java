package com.ujaen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ujaen.dto.DtoPiso;

public class DaoPiso implements DaoPiso_interface {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/inmobiliaria";
	Connection conn;

	public DaoPiso() {
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

	public ArrayList<DtoPiso> listar() {
		ArrayList<DtoPiso> lpisos = new ArrayList<DtoPiso>();
		DtoPiso piso;
		String sql = "Select * from piso;";
		ResultSet rs = null;
		getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7));
				lpisos.add(piso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lpisos;
	}
}
