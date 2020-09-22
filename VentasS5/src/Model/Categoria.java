package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Database.Conexion;

public class Categoria {
	private String codigo;
	private String nombre;
	
	public Categoria() {
		this.codigo="";
		this.nombre="";		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String AgregarCateogria() throws SQLException {
		String data;
		try {
			Conexion cdx = new Conexion();
			Connection con = cdx.conectar();
			PreparedStatement ps;
			// Statement smt;
			// ResultSet rs;

			String query = "INSERT INTO `categoria`(`nombre`) VALUES (?)";
			// String query="SELECT COUNT(*) AS CANTIDAD FROM usuarios WHERE user=? AND
			// password=?";
			PreparedStatement stmt = con.prepareStatement(query);
			//stmt.setString(1, this.codigo);
			stmt.setString(1, this.nombre);
			stmt.executeUpdate();
			data = "success";
		} catch (Exception e) {
			e.printStackTrace();
			data = "fail";
		}
		return data;
	}
	
	
	public String ListadoCategoria() {
		String query = "SELECT * FROM categoria";
		Conexion cdx = new Conexion();
		Connection con;
		con = cdx.conectar();
		String json = cdx.resultSetToJson(con, query);
		return json;

	}
	

}
