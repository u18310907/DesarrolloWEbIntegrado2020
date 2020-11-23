package Controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import Database.galeriaDB;
import Database.juegosDB;
import Model.Galeria;
import Model.Juegos;

@ManagedBean(name = "controllerManagedGaleria")
@RequestScoped
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

	// Lista
	private String lstVista;
	private String lstcodjue;
	private String lstTitulo;
	private juegosDB gamesDB;

	
	
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
	
	
	public void resultado() {
		Galeria gl=new Galeria();
		gl.setCodigo(Integer.parseInt(lstVista));
		gl.setCodjue(Integer.parseInt(lstcodjue));
		 galeDB= new galeriaDB();
		 try {
			String respawn=galeDB.ActualizarVista(gl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Juegos> getjuegoSelect(){
		 ArrayList<Juegos> juegoSelect = new ArrayList<Juegos>();
		 gamesDB= new juegosDB();
		 juegoSelect= gamesDB.ALLGames();
		 return juegoSelect;
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
	
	public ArrayList<Galeria> getgaleListContact(){
		 String view="Conctact";
		 ArrayList<Galeria> galeListContact = new ArrayList<Galeria>();
		 galeDB= new galeriaDB();
		 galeListContact= galeDB.leerGaleria(view);
		 return galeListContact;
	}
	
	public ArrayList<Galeria> getgaleListHome(){
		 String view="Home";
		 ArrayList<Galeria> galeListContact = new ArrayList<Galeria>();
		 galeDB= new galeriaDB();
		 galeListContact= galeDB.leerGaleria(view);
		 return galeListContact;
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

	public String getLstVista() {
		return lstVista;
	}


	public void setLstVista(String lstVista) {
		this.lstVista = lstVista;
	}

	public String getLstcodjue() {
		return lstcodjue;
	}

	public void setLstcodjue(String lstcodjue) {
		this.lstcodjue = lstcodjue;
	}

	public String getLstTitulo() {
		return lstTitulo;
	}

	public void setLstTitulo(String lstTitulo) {
		this.lstTitulo = lstTitulo;
	}
	public juegosDB getGamesDB() {
		return gamesDB;
	}
	
	
	

}
