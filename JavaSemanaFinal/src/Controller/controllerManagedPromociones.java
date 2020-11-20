package Controller;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import Database.promocionDB;
import Model.Promocion;


@ManagedBean(name = "controllerManagedPromociones")
@SessionScoped
public class controllerManagedPromociones {
	private Integer codigo;
	private Integer codjue;
	private String titulo;
	private String descripcion;
	private Double descuento;
	private promocionDB promoDB;

	private static ArrayList<Promocion> promoList;
	
	public controllerManagedPromociones() {
		promoDB = new promocionDB();
		promoList = promoDB.leerpromociones();
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public Integer getCodjue() {
		return codjue;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getDescuento() {
		return descuento;
	}



	public promocionDB getPromoDB() {
		return promoDB;
	}
	

	public ArrayList<Promocion> getpromoList() {
		return promoList;
	}

}
