package Controller;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Database.juegosDB;
import Model.Juegos;

@ManagedBean(name = "controllerManagedBean")
@SessionScoped
public class controllerManagedJuegos {
	private Integer codigo;
	private String titulo;
	private String descripcion;
	private Integer categoria_id;
	private String nombre;
	private String observacion;
	private String imagenName;
	private Double precio;
	private juegosDB gamesDB;

	//private static ArrayList<Juegos> juegoList;

	public controllerManagedJuegos() {
		//gamesDB = new juegosDB();
		//juegoList = gamesDB.leerjuegos();
	}

	public ArrayList<Juegos> getjuegoList(){
		 ArrayList<Juegos> juegoList = new ArrayList<Juegos>();
		 gamesDB= new juegosDB();
		 juegoList= gamesDB.leerjuegos();
		 return juegoList;
	}
	

	
	public ArrayList<Juegos> gettopList(){
		 ArrayList<Juegos> topList = new ArrayList<Juegos>();
		 gamesDB= new juegosDB();
		 topList= gamesDB.leerUltimos();
		 return topList;
	}
	
	
	public ArrayList<Juegos> gettopCosto(){
		 ArrayList<Juegos> topcosto = new ArrayList<Juegos>();
		 gamesDB= new juegosDB();
		 topcosto= gamesDB.TopCosto();
		 return topcosto;
	}
	
	public ArrayList<Juegos> getlowCosto(){
		 ArrayList<Juegos> lowcosto = new ArrayList<Juegos>();
		 gamesDB= new juegosDB();
		 lowcosto= gamesDB.LowCosto();
		 return lowcosto;
	}
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public String getObservacion() {
		return observacion;
	}

	public String getImagenName() {
		return imagenName;
	}


	public juegosDB getGamesDB() {
		return gamesDB;
	}
	

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

/*
	public ArrayList<Juegos> getjuegoList() {
		return juegoList;
	}
	*/

}
