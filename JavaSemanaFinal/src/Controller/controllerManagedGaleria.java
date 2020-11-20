package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;

import Database.galeriaDB;
import Database.juegosDB;
import Model.Galeria;
import Model.Juegos;

@ManagedBean(name = "controllerManagedGaleria")
@SessionScoped
public class controllerManagedGaleria implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Integer codjue;
	private String titulo;
	private String descripcion;
	private String imagenName;
	private Integer estado;
	private galeriaDB galeDB;

	//private static ArrayList<Galeria> galeListBlog;
		
	public controllerManagedGaleria() {
		
		// System.out.println("Vista"+vista);
		// galeDB = new galeriaDB();
		// galeList = galeDB.leerGaleria();
		/*
		 * FacesContext context=FacesContext.getCurrentInstance(); HttpServletRequest
		 * request = (HttpServletRequest) context.getExternalContext().getRequest();
		 * String activeIndex = (String) request.getAttribute("activeIndex");
	
		 */
	/*	FacesContext facesContext = FacesContext.getCurrentInstance();
		String urlview = (String)  facesContext.getExternalContext().getSessionMap().get("urlview");
		if(urlview!=null) {
				System.out.println("urlview"+urlview);
				}
				else {
				System.out.println("urlview"+urlview);			
				}
*/

	}
	
	public ArrayList<Galeria> getgaleListBlog(){
		String view="Blog";
		 ArrayList<Galeria> galeListBlog = new ArrayList<Galeria>();
		 galeDB= new galeriaDB();
		 galeListBlog= galeDB.leerGaleria(view);
		 return galeListBlog;
	}
	
	
	public ArrayList<Galeria> getgaleListGames(){
		 String view="Games";
		 ArrayList<Galeria> galeListBlog = new ArrayList<Galeria>();
		 galeDB= new galeriaDB();
		 galeListBlog= galeDB.leerGaleria(view);
		 return galeListBlog;
	}
	
	
	public ArrayList<Galeria> getgaleListForum(){
		 String view="Foro";
		 ArrayList<Galeria> galeListBlog = new ArrayList<Galeria>();
		 galeDB= new galeriaDB();
		 galeListBlog= galeDB.leerGaleria(view);
		 return galeListBlog;
	}
	
	public ArrayList<Galeria> getgaleListAdmin(){
		 String view="Admin";
		 ArrayList<Galeria> galeListAdmin = new ArrayList<Galeria>();
		 galeDB= new galeriaDB();
		 galeListAdmin = galeDB.leerGaleria(view);
		 return galeListAdmin;
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

	public String getImagenName() {
		return imagenName;
	}

	public Integer getEstado() {
		return estado;
	}

	public galeriaDB getGaleDB() {
		return galeDB;
	}



}
