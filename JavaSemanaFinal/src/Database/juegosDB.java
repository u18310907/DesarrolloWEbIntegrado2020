package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Juegos;

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
					"SELECT j.codigo,titulo,descripcion,observacion,ImagenName,c.nombre FROM juegos j INNER JOIN categoria c on c.codigo=j.categoria_id");
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
			jueResultSet = stm.executeQuery("SELECT codigo,titulo,descripcion,ImagenName FROM juegos ORDER BY precio DESC LIMIT 1");
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
			jueResultSet = stm.executeQuery("SELECT codigo,titulo,descripcion,ImagenName FROM juegos ORDER BY precio asc LIMIT 1");
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

}
