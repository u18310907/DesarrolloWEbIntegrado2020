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

import Model.Juegos;
import Model.ListDeseos;

public class juegosDB {
	private Connection conexion = null;
	private Statement stm = null;
	private ResultSet jueResultSet;
	private Integer codigo;
	private String titulo;
	private String descripcion;
	// private Integer categoria_id;
	private String observacion;
	private String imagenName;
	private String nombre;
	private Double precio;

	public ArrayList<Juegos> leerjuegos() {
		ArrayList<Juegos> Juegos = new ArrayList<Juegos>();
		Juegos jueHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			jueResultSet = stm.executeQuery(
					"SELECT j.codigo,titulo,descripcion,observacion,ImagenName,c.nombre FROM juegos j INNER JOIN categoria c on c.codigo=j.categoria_id WHERE j.codigo!=1");
			if (!jueResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = jueResultSet.getInt("codigo");
					titulo = jueResultSet.getString("titulo");
					descripcion = jueResultSet.getString("descripcion");
					nombre = jueResultSet.getString("nombre");

					imagenName = jueResultSet.getString("ImagenName");
					observacion = jueResultSet.getString("observacion");

					jueHallada = new Juegos(codigo, titulo, descripcion, nombre, observacion, imagenName);
					Juegos.add(jueHallada);
				} while (jueResultSet.next());
				conexion.close();
				return Juegos;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Juegos> leerUltimos() {
		ArrayList<Juegos> Juegos = new ArrayList<Juegos>();
		Juegos jueHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			jueResultSet = stm.executeQuery(
					"SELECT codigo,titulo,descripcion,ImagenName,precio FROM juegos ORDER by codigo DESC LIMIT 3");
			if (!jueResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = jueResultSet.getInt("codigo");
					titulo = jueResultSet.getString("titulo");
					descripcion = jueResultSet.getString("descripcion");
					imagenName = jueResultSet.getString("ImagenName");
					precio = jueResultSet.getDouble("precio");
					jueHallada = new Juegos(codigo, titulo, descripcion, imagenName, precio);
					Juegos.add(jueHallada);
				} while (jueResultSet.next());
				conexion.close();
				return Juegos;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Juegos> TopCosto() {
		ArrayList<Juegos> Juegos = new ArrayList<Juegos>();
		Juegos jueHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			jueResultSet = stm.executeQuery(
					"SELECT codigo,titulo,descripcion,ImagenName FROM juegos ORDER BY precio DESC LIMIT 1");
			if (!jueResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = jueResultSet.getInt("codigo");
					titulo = jueResultSet.getString("titulo");
					descripcion = jueResultSet.getString("descripcion");
					imagenName = jueResultSet.getString("ImagenName");
					jueHallada = new Juegos(codigo, titulo, descripcion, imagenName);
					Juegos.add(jueHallada);
				} while (jueResultSet.next());
				conexion.close();
				return Juegos;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Juegos> LowCosto() {
		ArrayList<Juegos> Juegos = new ArrayList<Juegos>();
		Juegos jueHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			jueResultSet = stm.executeQuery(
					"SELECT codigo,titulo,descripcion,ImagenName,precio FROM juegos  WHERE codigo!=1 ORDER BY precio asc LIMIT 1");
			if (!jueResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = jueResultSet.getInt("codigo");
					titulo = jueResultSet.getString("titulo");
					descripcion = jueResultSet.getString("descripcion");
					imagenName = jueResultSet.getString("ImagenName");
					precio = jueResultSet.getDouble("precio");
					jueHallada = new Juegos(codigo, titulo, descripcion, imagenName, precio);
					Juegos.add(jueHallada);
				} while (jueResultSet.next());
				conexion.close();
				return Juegos;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Juegos> ALLGames() {
		ArrayList<Juegos> Juegos = new ArrayList<Juegos>();
		Juegos jueHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			jueResultSet = stm.executeQuery("SELECT codigo,titulo FROM juegos where codigo!=1");
			if (!jueResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = jueResultSet.getInt("codigo");
					titulo = jueResultSet.getString("titulo");
					jueHallada = new Juegos(codigo, titulo, "", "");
					Juegos.add(jueHallada);
				} while (jueResultSet.next());
				conexion.close();
				return Juegos;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Juegos> leerVentasJuegos() {
		ArrayList<Juegos> Juegos = new ArrayList<Juegos>();
		Juegos jueHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			jueResultSet = stm.executeQuery(
					"SELECT DISTINCT j.codigo,titulo,descripcion,observacion,ImagenName,c.nombre FROM juegos j INNER JOIN categoria c on c.codigo=j.categoria_id INNER JOIN venta V ON j.codigo=V.codjue WHERE j.codigo!=1 ORDER BY v.codigo DESC LIMIT 4");
			if (!jueResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = jueResultSet.getInt("codigo");
					titulo = jueResultSet.getString("titulo");
					descripcion = jueResultSet.getString("descripcion");
					nombre = jueResultSet.getString("nombre");

					imagenName = jueResultSet.getString("ImagenName");
					observacion = jueResultSet.getString("observacion");

					jueHallada = new Juegos(codigo, titulo, descripcion, nombre, observacion, imagenName);
					Juegos.add(jueHallada);
				} while (jueResultSet.next());
				conexion.close();
				return Juegos;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<Juegos> leerVentasPrecio() {
		ArrayList<Juegos> Juegos = new ArrayList<Juegos>();
		Juegos jueHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			jueResultSet = stm.executeQuery(
					"SELECT DISTINCT j.codigo,titulo,descripcion,observacion,ImagenName,c.nombre,j.precio FROM juegos j INNER JOIN categoria c on c.codigo=j.categoria_id INNER JOIN venta V ON j.codigo=V.codjue WHERE j.codigo!=1 ORDER BY j.precio DESC LIMIT 4");
			if (!jueResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = jueResultSet.getInt("codigo");
					titulo = jueResultSet.getString("titulo");
					descripcion = jueResultSet.getString("descripcion");
					nombre = jueResultSet.getString("nombre");
					
					imagenName = jueResultSet.getString("ImagenName");
					observacion = jueResultSet.getString("observacion");
					precio = jueResultSet.getDouble("precio");

					jueHallada = new Juegos(codigo, titulo, descripcion, nombre, observacion, imagenName,precio);
					Juegos.add(jueHallada);
				} while (jueResultSet.next());
				conexion.close();
				return Juegos;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}


	public String RegistrarJuego(Juegos J) throws SQLException {
		String data;
		try {

			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "INSERT INTO juegos(titulo, descripcion, categoria_id, observacion, ImagenName, precio) VALUES (?,?,?,?,?,?)";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, J.getTitulo());
			stmt.setString(2, J.getDescripcion());
			stmt.setInt(3, J.getCategoria_id());
			stmt.setString(4, J.getObservacion());
			stmt.setString(5, J.getImagenName());
			stmt.setDouble(6, J.getPrecio());
			stmt.executeUpdate();
			data = "success";

		} catch (Exception e) {
			// e.printStackTrace();
			data = "fail";
		}
		// conexion.close();
		return data;
	}

	public String ActualizarJuego(Juegos J) throws SQLException {
		String data;
		try {

			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query;
			if (J.getImagenName().equalsIgnoreCase("")) {
				query = "UPDATE juegos SET titulo=?,descripcion=?,categoria_id=?,observacion=?,precio=? WHERE codigo=?";

			} else {
				query = "UPDATE juegos SET titulo=?,descripcion=?,categoria_id=?,observacion=?,ImagenName=?,precio=? WHERE codigo=?";
			}
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, J.getTitulo());
			stmt.setString(2, J.getDescripcion());
			stmt.setInt(3, J.getCategoria_id());
			stmt.setString(4, J.getObservacion());
			if (J.getImagenName().equalsIgnoreCase("")) {
				stmt.setDouble(5, J.getPrecio());
				stmt.setInt(6, J.getCodigo());
				
			}
			else {
				stmt.setString(5, J.getImagenName());
				stmt.setDouble(6, J.getPrecio());
				stmt.setInt(7, J.getCodigo());
				
				
			}
			stmt.executeUpdate();
	
			data = "success";

		} catch (Exception e) {
			// e.printStackTrace();
			data = "fail";
		}
		// conexion.close();
		return data;
	}

	public String JuegosInputsServ(Integer codigo) {
		ConexionDB conectaBD = new ConexionDB();
		conexion = conectaBD.conectar();
		String query;
		query = "SELECT * FROM juegos WHERE codigo=" + codigo + "";
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
