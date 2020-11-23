package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Foro;
import Model.Galeria;


public class galeriaDB {
	private Connection conexion = null;
	private Statement stm = null;
	private ResultSet galResultSet;
	private Integer codigo;
	private Integer codjue;
	private String titulo;
	private String descripcion;
	private String imagenName;


	public ArrayList<Galeria> leerGaleria(String view) {
		ArrayList<Galeria> galeria = new ArrayList<Galeria>();
		Galeria galHallada;
		try {
			ConexionDB conectaBD = new ConexionDB();
			conexion = conectaBD.conectar();
			stm = conexion.createStatement();
			galResultSet = stm.executeQuery("SELECT g.codigo,g.codjue,j.titulo,j.descripcion,j.ImagenName FROM galeria g  INNER join juegos j  ON j.codigo=g.codjue WHERE estado= 1  and vista='"+view+"' LIMIT 1");
			if (!galResultSet.next()) {
				System.out.println(" No se encontraron registros");
				conexion.close();
				return null;
			} else {
				do {
					codigo = galResultSet.getInt("codigo");
					codjue = galResultSet.getInt("codjue");
					titulo = galResultSet.getString("titulo");
					descripcion = galResultSet.getString("descripcion");
					imagenName = galResultSet.getString("imagenName");
					galHallada = new Galeria(codigo, codjue, titulo,descripcion , imagenName);
					galeria.add(galHallada);
				} while (galResultSet.next());
				conexion.close();
				return galeria;
			}
		} catch (Exception e) {
			System.out.println("Error en la base de datos.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String ActualizarVista(Galeria gl) throws SQLException {
		String data;
		try {
					
			ConexionDB conectaBD = new ConexionDB();
			Connection con = conectaBD.conectar();
			String query = "UPDATE galeria SET codjue=? WHERE codigo=?";
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);			
			stmt.setInt(1,gl.getCodjue());
			stmt.setInt(2,gl.getCodigo());
			stmt.executeUpdate();
			data = "success";
		
		} catch (Exception e) {
				//e.printStackTrace();
			data = "fail";
		}
		//conexion.close();
		return data;
	}
	


}
