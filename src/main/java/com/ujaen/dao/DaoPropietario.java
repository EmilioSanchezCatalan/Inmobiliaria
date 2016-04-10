package com.ujaen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.ujaen.dto.DtoPropietario;


public class DaoPropietario implements DaoPropietario_interface {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/inmobiliaria";
		Connection conn;

		public DaoPropietario() {
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
		
		public void insertar(DtoPropietario propietario){
			String sql = "INSERT into Propietario (dni,nombre,apellidos,tlf,correo) VALUES(?,?,?,?,?);";
			getConnection();
			try {
				PreparedStatement smt = conn.prepareStatement(sql);
				smt.setString(1, propietario.getDni());
				smt.setString(2, propietario.getNombre());
				smt.setString(3, propietario.getApellidos());
				smt.setString(4, propietario.getTlf());
				smt.setString(5, propietario.getCorreo());
				smt.execute();
				smt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
}