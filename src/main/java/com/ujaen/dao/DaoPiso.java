package com.ujaen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7));
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
}
