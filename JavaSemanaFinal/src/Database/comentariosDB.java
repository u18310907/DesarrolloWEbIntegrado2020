package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Comentarios;

public class comentariosDB {
	private Connection conexion = null;
	private Statement stm = null;
	private ResultSet comResultSet;
	private Integer codigo;
	private String titulo;
	private String comentario;
	private String usuario;
	private String imagenName;
	private String fecha;


	public ArrayList<Comentarios> leercom() {
		ArrayList<Comentarios> comentarios = new ArrayList<Comentarios>();
		Comentarios comHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			comResultSet = stm.executeQuery(
					"SELECT C.codigo,J.titulo,C.comentario,U.usuario,u.ImagenName,C.fecha  FROM comentarios C INNER JOIN juegos J ON C.codjuego=J.codigo INNER JOIN usuario U ON U.codigo=C.coduser ORDER BY codigo DESC LIMIT 3");
			if (!comResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = comResultSet.getInt("codigo");
					titulo = comResultSet.getString("titulo");
					comentario = comResultSet.getString("comentario");
					usuario = comResultSet.getString("usuario");
					imagenName = comResultSet.getString("ImagenName");
					fecha = comResultSet.getString("fecha");
					comHallada = new Comentarios(codigo, titulo,comentario , usuario,imagenName,fecha);
					comentarios.add(comHallada);
				} while (comResultSet.next());
				conexion.close();
				return comentarios;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<Comentarios> leercomFull() {
		ArrayList<Comentarios> comentarios = new ArrayList<Comentarios>();
		Comentarios comHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			comResultSet = stm.executeQuery(
					"SELECT C.codigo,J.titulo,C.comentario,U.usuario,u.ImagenName,C.fecha  FROM comentarios C INNER JOIN juegos J ON C.codjuego=J.codigo INNER JOIN usuario U ON U.codigo=C.coduser ORDER BY codigo DESC LIMIT 10 ");
			if (!comResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = comResultSet.getInt("codigo");
					titulo = comResultSet.getString("titulo");
					comentario = comResultSet.getString("comentario");
					usuario = comResultSet.getString("usuario");
					imagenName = comResultSet.getString("ImagenName");
					fecha = comResultSet.getString("fecha");
					comHallada = new Comentarios(codigo, titulo,comentario , usuario,imagenName,fecha);
					comentarios.add(comHallada);
				} while (comResultSet.next());
				conexion.close();
				return comentarios;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}

}
