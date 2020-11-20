package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Foro;
import Model.ListDeseos;


public class ForoDB {

	private Connection conexion = null;
	private Statement stm = null;
	private ResultSet foroResultSet;
	private String cantidad;
	
	public String userCantidad() {
		try {
	ConexionDB conectaBD = new ConexionDB();
	conexion = conectaBD.conectar();
	ResultSet rs;
	String query = "SELECT COUNT(*) as cantidad FROM usuario";
	PreparedStatement stmt = conexion.prepareStatement(query);
	rs = stmt.executeQuery();
	while (rs.next()) {
		cantidad = rs.getString("cantidad");
	}
	return cantidad;
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String RegistrarComentarios(Foro fr) throws SQLException {
		String data;
		try {
					
			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "INSERT INTO `comentarios`(`coduser`, `codjuego`, `comentario`, `fecha`) VALUES (?,?,?,?)";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setInt(1,fr.getCoduser());
			stmt.setInt(2,fr.getCodjuego());
			stmt.setString(3,fr.getComentario());
			stmt.setString(4,fr.getFecha());
			stmt.executeUpdate();
			data = "success";
		
		} catch (Exception e) {
				//e.printStackTrace();
			data = "fail";
		}
		//conexion.close();
		return data;
	}
	
	
	/*
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
	}*/
}


