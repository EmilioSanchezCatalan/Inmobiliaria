package com.ujaen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/inmobiliaria";
	Connection conn;

	public Dao() {
		cargarDriver();
	}

	private void cargarDriver() {
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, "ClientePisos", "pass");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
