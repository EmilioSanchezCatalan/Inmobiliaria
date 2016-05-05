package com.ujaen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ujaen.dao_interfaces.DaoPiso_interface;
import com.ujaen.dto.DtoAlumno;
import com.ujaen.dto.DtoPiso;
import com.ujaen.dto.DtoPropietario;

public class DaoPiso implements DaoPiso_interface {

	Dao dao;

	public DaoPiso() {
		dao = new Dao();
	}

	public ArrayList<DtoPiso> listar() {
		ArrayList<DtoPiso> lpisos = new ArrayList<DtoPiso>();
		DtoPiso piso;
		String sql = "Select * from piso where pagado = true;";
		ResultSet rs = null;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getFloat(10), rs.getBoolean(11),
						rs.getString(12));
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

	public ArrayList<DtoPiso> listarPropietario(DtoPropietario propietario) {
		ArrayList<DtoPiso> pisos = new ArrayList<DtoPiso>();
		DtoPiso piso;
		String sql = "select * from piso where dni_p = ?;";
		ResultSet rs = null;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setString(1, propietario.getDni());
			rs = stmt.executeQuery();
			while (rs.next()) {

				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getFloat(10), rs.getBoolean(11),
						rs.getString(12));
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
		String sql = "INSERT INTO Piso (imagenSalon, imagenCocina, imagenDormitorio, imagenBano, direccion, descripcion, plazas, plazas_libres, precio, pagado, dni_p) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
			smt.setInt(8, piso.getPlazas_libres());
			smt.setFloat(9, piso.getPrecio());
			smt.setBoolean(10, piso.isPagado());
			smt.setString(11, piso.getDni_p());
			smt.execute();
			smt.close();
			dao.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DtoPiso> PisosDisponibles() {
		ArrayList<DtoPiso> lpisos = new ArrayList<DtoPiso>();
		DtoPiso piso = null;
		String sql = "select * from piso where plazas_libres != 0 and pagado = true;";
		ResultSet rs = null;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getFloat(10), rs.getBoolean(11),
						rs.getString(12));
				lpisos.add(piso);
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lpisos;
	}

	public int totalPisos() {
		String sql = "Select count(cod_piso) from piso;";
		ResultSet rs = null;
		int total = 0;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return total;
	}

	public void actualizaPlazasMenos(DtoPiso piso) {

		// primera sentecia
		String sql = "select plazas_libres from piso where cod_piso = ?;";
		ResultSet rs = null;
		int plazas_libres = 0;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, piso.getCod_piso());
			rs = stmt.executeQuery();
			while (rs.next()) {
				plazas_libres = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		plazas_libres = plazas_libres - 1;
		// segunda sentecia
		sql = "update piso set plazas_libres = ? where cod_piso = ?;";
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, plazas_libres);
			stmt.setInt(2, piso.getCod_piso());
			stmt.execute();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void actualizaPlazasMas(DtoPiso piso) {

		// primera sentecia
		String sql = "select plazas_libres from piso where cod_piso = ?;";
		ResultSet rs = null;
		int plazas_libres = 0;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, piso.getCod_piso());
			rs = stmt.executeQuery();
			while (rs.next()) {
				plazas_libres = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		plazas_libres = plazas_libres + 1;
		// segunda sentecia
		sql = "update piso set plazas_libres = ? where cod_piso = ?;";
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, plazas_libres);
			stmt.setInt(2, piso.getCod_piso());
			stmt.execute();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public DtoPiso Piso(DtoPiso piso) {
		String sql = "select * from piso where cod_piso = ?;";
		ResultSet rs = null;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, piso.getCod_piso());
			rs = stmt.executeQuery();
			while (rs.next()) {
				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getFloat(10), rs.getBoolean(11),
						rs.getString(12));
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return piso;
	}

	public void BajaPiso(DtoPiso piso) {
		String sql = "delete from piso where cod_piso = ?;";
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, piso.getCod_piso());
			stmt.execute();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public DtoPiso miPiso(DtoAlumno alumno) {
		String sql = "select * from piso where cod_piso = (select cod_piso from alumnos where usuario = ?);";
		ResultSet rs = null;
		DtoPiso piso = null;
		dao.getConnection();
		try {
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setString(1, alumno.getUsuario());
			rs = stmt.executeQuery();
			while (rs.next()) {
				piso = new DtoPiso(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getFloat(10), rs.getBoolean(11),
						rs.getString(12));
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return piso;
	}
	public void pagado(){
		String sql = "select cod_piso from piso where pagado = false;";
		ResultSet rs = null;
		int cod_piso = 0;
		dao.getConnection();
		try{
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				cod_piso = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		sql = "update piso set pagado = true where cod_piso = ?";
		dao.getConnection();
		try{
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, cod_piso);
			stmt.execute();
			stmt.close();
			dao.conn.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	public void noPagado(){
		String sql = "select cod_piso from piso where pagado = false;";
		ResultSet rs = null;
		int cod_piso = 0;
		dao.getConnection();
		try{
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				cod_piso = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			dao.conn.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		sql = "delete from piso where cod_piso = ?;";
		dao.getConnection();
		try{
			PreparedStatement stmt = dao.conn.prepareStatement(sql);
			stmt.setInt(1, cod_piso);
			stmt.execute();
			stmt.close();
			dao.conn.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
