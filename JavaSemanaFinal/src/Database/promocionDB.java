package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.google.gson.Gson;

import Model.Foro;
import Model.Promocion;

public class promocionDB {
	private Connection conexion = null;
	private Statement stm = null;
	private ResultSet proResultSet;
	private Integer codigo;
	private Integer codjue;
	private String titulo;
	private String descripcion;
	private Double descuento;

	public ArrayList<Promocion> leerpromociones() {
		ArrayList<Promocion> promocion = new ArrayList<Promocion>();
		Promocion proHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			proResultSet = stm.executeQuery(
					"SELECT p.codigo,j.codigo as 'codjue',j.titulo,p.descripcion,p.descuento FROM promocion p inner JOIN juegos j on p.codjue=j.codigo  WHERE estado=1 order BY  p.codigo DESC");
			if (!proResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = proResultSet.getInt("codigo");
					codjue = proResultSet.getInt("codjue");
					titulo = proResultSet.getString("titulo");
					descripcion = proResultSet.getString("descripcion");
					descuento = proResultSet.getDouble("descuento");
					proHallada = new Promocion(codigo, codjue, titulo,descripcion , descuento);
					promocion.add(proHallada);
				} while (proResultSet.next());
				conexion.close();
				return promocion;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public ArrayList<Promocion> leerPublicados() {
		ArrayList<Promocion> promocion = new ArrayList<Promocion>();
		Promocion proHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			proResultSet = stm.executeQuery(
					"SELECT p.codigo,j.codigo as 'codjue',j.titulo FROM promocion p inner JOIN juegos j on p.codjue=j.codigo  order BY  p.codigo DESC");
			if (!proResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = proResultSet.getInt("codigo");
					codjue = proResultSet.getInt("codjue");
					titulo = proResultSet.getString("titulo");
					proHallada = new Promocion(codigo, codjue, titulo);
					promocion.add(proHallada);
				} while (proResultSet.next());
				conexion.close();
				return promocion;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String RegistrarPromocion(Promocion pr) throws SQLException {
		String data;
		try {
					
			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "INSERT INTO `promocion`(`codjue`, `descripcion`, `descuento`, `estado`) VALUES (?,?,?,?)";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setInt(1,pr.getCodjue());
			stmt.setString(2,pr.getDescripcion());
			stmt.setDouble(3,pr.getDescuento());
			stmt.setString(4,pr.getEstado());
			stmt.executeUpdate();
			data = "success";
		
		} catch (Exception e) {
				//e.printStackTrace();
			data = "fail";
		}
		//conexion.close();
		return data;
	}
	
	
	public String ActualizarPromocion(Promocion pr) throws SQLException {
		String data;
		try {
					
			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "UPDATE promocion SET codjue=?,descripcion=?,descuento=?,estado=? WHERE codigo=?";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setInt(1,pr.getCodjue());
			stmt.setString(2,pr.getDescripcion());
			stmt.setDouble(3,pr.getDescuento());
			stmt.setString(4,pr.getEstado());
			stmt.setInt(5,pr.getCodigo());
			stmt.executeUpdate();
			data = "success";
		
		} catch (Exception e) {
				//e.printStackTrace();
			data = "fail";
		}
		//conexion.close();
		return data;
	}
	
	
	
	
	public  String  PromoInputsServ(Integer codigo)  {
		ConexionDB conectaBD = new ConexionDB();
		conexion = conectaBD.conectar();
		String query;
		query = "SELECT p.codigo,j.codigo as 'codjue',j.titulo,p.descripcion,p.descuento,p.estado FROM promocion p inner JOIN juegos j on p.codjue=j.codigo  WHERE P.codigo="+codigo+"";
		System.out.println(query);
		List<Map<String, Object>> listOfMaps = null;
		try {
			QueryRunner queryRunner = new QueryRunner();
			listOfMaps = queryRunner.query(conexion, query, new MapListHandler());

		} catch (SQLException se) {
			throw new RuntimeException("No se puedo Ejecutar la Consulta.", se);
		} finally {
			DbUtils.closeQuietly(conexion);
		}
		return new Gson().toJson(listOfMaps);
	}

}
