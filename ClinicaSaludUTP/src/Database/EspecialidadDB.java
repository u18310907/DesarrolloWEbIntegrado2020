package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.google.gson.Gson;

import Model.EspecialidadBean;

public class EspecialidadDB {
	public String RegistrarEspecialidad(EspecialidadBean E) throws SQLException {
		String data;
		ConexionDB conectaBD = new ConexionDB();
		try {
			Connection con = conectaBD.conectar();
			String query = "INSERT INTO `rol`(`nom_Rol`, `descr_Rol`) VALUES (?,?)";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, E.getNom_Rol());
			stmt.setString(2, E.getDescr_Rol());
			stmt.executeUpdate();
			data = "success";
			

		} catch (Exception e) {
			// e.printStackTrace();
			data = "fail";
		}
		conectaBD.cerrarConexion();
		return data;
	}
	
	public String ActualizarESpecialidad(EspecialidadBean E) throws SQLException {
		String data;
		ConexionDB conectaBD = new ConexionDB();
		try {
			Connection con = conectaBD.conectar();
			String query = "UPDATE rol SET nom_Rol=?,`descr_Rol`=? WHERE `cod_Rol`= ?";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, E.getNom_Rol());
			stmt.setString(2, E.getDescr_Rol());
			stmt.setInt(3, E.getCodigo());
			stmt.executeUpdate();
			data = "success";

		} catch (Exception e) {
			// e.printStackTrace();
			data = "fail";
		}
		conectaBD.cerrarConexion();
		return data;
	}
	
	
	public  String  ListarEspecialidad()  {
		ConexionDB conectaBD = new ConexionDB();
		Connection con = conectaBD.conectar();
		String query;

		query = "SELECT cod_Rol,nom_Rol FROM rol";
	
		List<Map<String, Object>> listOfMaps = null;
		try {
			QueryRunner queryRunner = new QueryRunner();
			listOfMaps = queryRunner.query(con, query, new MapListHandler());

		} catch (SQLException se) {
			throw new RuntimeException("No se puedo Ejecutar la Consulta.", se);
		} finally {
			DbUtils.closeQuietly(con);
		}
		return new Gson().toJson(listOfMaps);
	}
	
	public  String  ListarEspecialidadById(EspecialidadBean E)  {
		ConexionDB conectaBD = new ConexionDB();
		Connection con = conectaBD.conectar();
		String query;

		query = "SELECT cod_Rol,nom_Rol,descr_Rol FROM rol WHERE cod_Rol="+E.getCodigo()+"";
	
		List<Map<String, Object>> listOfMaps = null;
		try {
			QueryRunner queryRunner = new QueryRunner();
			listOfMaps = queryRunner.query(con, query, new MapListHandler());

		} catch (SQLException se) {
			throw new RuntimeException("No se puedo Ejecutar la Consulta.", se);
		} finally {
			DbUtils.closeQuietly(con);
		}
		return new Gson().toJson(listOfMaps);
	}
}
