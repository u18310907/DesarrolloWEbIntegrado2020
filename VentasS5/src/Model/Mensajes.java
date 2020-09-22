package Model;

import java.sql.Connection;

import Database.Conexion;

public class Mensajes {

	private String autor;
	private String mensaje;
	private int tipo;

	public Mensajes() {
		autor = "";
		mensaje = "";
		tipo = 0;
	}
	
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
/*
	public Mensajes(String autor, String mensaje, int tipo) {
		if (tipo == 0) {
			this.mensaje = "Este es un anuncio publicado para todos los compradores";
			this.autor = "Juan Manuel";
			this.tipo = tipo;

		} else {
			this.mensaje = "Este es una promocion que se llevara a cabo de lunes a viernes";
			this.autor = "Promociones Ventasl";
			this.tipo = tipo;

		}

	}*/
	
	public String ObtenerPublicacion() {
		String query;
		if (this.tipo == 0) {
			 query = "SELECT * FROM `anuncios`";
		} else {
			 query = "SELECT * FROM `promociones`";
		}
		Conexion cdx = new Conexion();
		Connection con;
		con = cdx.conectar();
		
		String json = cdx.resultSetToJson(con, query);
		return json;
		
	}


	
	

}
