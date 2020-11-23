package Controller;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Database.comentariosDB;
import Model.Comentarios;

@ManagedBean(name = "controllerManagedComentario")
@SessionScoped
public class controllerManagedComentario {
	private Integer codigo;
	private String titulo;
	private String comentario;
	private String usuario;
	private String imagenName;
	private String fecha;
	private comentariosDB comDB;

	//private static ArrayList<Comentarios> comList;
	
	public controllerManagedComentario() {
		//comDB = new comentariosDB();
		//comList = comDB.leercom();
	}
	
	public ArrayList<Comentarios> getcomListTop() {
		ArrayList<Comentarios> comList = new ArrayList<Comentarios>();
		comDB = new comentariosDB();
		comList = comDB.leercom();
		return comList;
	}
	
	
	
	public ArrayList<Comentarios> getcomListFull() {
		ArrayList<Comentarios> getcomListFull = new ArrayList<Comentarios>();
		comDB = new comentariosDB();
		getcomListFull = comDB.leercomFull();
		return getcomListFull;
	}
	
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getComentario() {
		return comentario;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getImagenName() {
		return imagenName;
	}

	public String getFecha() {
		return fecha;
	}
	
	public comentariosDB getcomDB() {
		return comDB;
		
	}


	


}
