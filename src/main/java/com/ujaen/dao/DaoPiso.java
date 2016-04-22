package com.ujaen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ujaen.dto.DtoAutentifica;
import com.ujaen.dto.DtoPiso;

public class DaoPiso implements DaoPiso_interface{
	
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
				piso = new DtoPiso(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
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
			stmt.setString(1,dni);
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				piso = new DtoPiso(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
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
	
	public void insertarPiso(DtoPiso piso){
		String sql = "INSERT INTO Piso (imagen,direccion,descripcion,plazas,precio,dni_p) VALUES(?,?,?,?,?,?);";
		dao.getConnection();
		try {
			PreparedStatement smt = dao.conn.prepareStatement(sql);
			smt.setString(1, piso.getImagen());
			smt.setString(2, piso.getDireccion());
			smt.setString(3, piso.getDescripcion());
			smt.setString(4, piso.getPlazas());
			smt.setString(5, piso.getPrecio());
			smt.setString(6, piso.getDni_p());
			smt.execute();
			smt.close();
			dao.conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DtoPiso> listarPlazas(String plazas) {
		ArrayList<DtoPiso> pisos = new ArrayList<DtoPiso>();
		DtoPiso piso;
		String sql = "select * from piso where plazas = ?;";
		ResultSet rs = null;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setString(1,plazas);
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				piso = new DtoPiso(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
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
}
