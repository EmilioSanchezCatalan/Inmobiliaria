package com.ujaen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ujaen.dao_interfaces.DaoPiso_interface;
import com.ujaen.dto.DtoPiso;

public class DaoPiso implements DaoPiso_interface {

	Dao dao;

	public DaoPiso() {
		dao = new Dao();
	}

	public ArrayList<DtoPiso> listar() {
		ArrayList<DtoPiso> lpisos = new ArrayList<DtoPiso>();
		DtoPiso piso;
		String sql = "Select * from piso;";
		ResultSet rs = null;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getFloat(9), rs.getString(10));
				lpisos.add(piso);
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lpisos;
	}

	public ArrayList<DtoPiso> listarPropietario(String dni) {
		ArrayList<DtoPiso> pisos = new ArrayList<DtoPiso>();
		DtoPiso piso;
		String sql = "select * from piso where dni_p = ?;";
		ResultSet rs = null;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			while (rs.next()) {

				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getFloat(9), rs.getString(10));
				pisos.add(piso);
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pisos;
	}

	public void insertarPiso(DtoPiso piso) {
		String sql = "INSERT INTO Piso (imagenSalon, imagenCocina, imagenDormitorio, imagenBano, direccion, descripcion, plazas, precio, dni_p) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, piso.getImagenSalon());		
			smt.setString(2, piso.getImagenCocina());
			smt.setString(3, piso.getImagenDormitorio());
			smt.setString(4, piso.getImagenBano());
			smt.setString(5, piso.getDireccion());
			smt.setString(6, piso.getDescripcion());
			smt.setInt(7, piso.getPlazas());
			smt.setFloat(8, piso.getPrecio());
			smt.setString(9, piso.getDni_p());
			smt.execute();
			smt.close();
			dao.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int totalPisos(){
		String sql = "Select count(cod_piso) from piso;";
		ResultSet rs = null;
		int total = 0;
		dao.getConnection();
		try{
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				total = rs.getInt(1);
			}
		}catch(SQLException ex){
			ex.getMessage();
		}
		return total;
	}
}
